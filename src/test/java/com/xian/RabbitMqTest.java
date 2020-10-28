package com.xian;

import com.rabbitmq.client.AMQP;
import com.xian.entities.DepartmentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/27 20:19
 * @Description:
 */
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        for (int i = 0; i < 10; i++) {
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId(i);
            departmentEntity.setDepName("开发");
            rabbitTemplate.convertAndSend("hello-java-exchange","hello.java",
                    departmentEntity);
        }



        //rabbitTemplate.convertAndSend("hello-java-exchange","hello.java","hello113");

    }





    @Test
    public void creatExchange(){
        DirectExchange directExchange = new DirectExchange("hello-java-exchange",true,false);
        amqpAdmin.declareExchange(directExchange);
    }

    @Test
    public void creatQueue(){
        Queue queue = new Queue("hello-java-queue",true,false,false);
        amqpAdmin.declareQueue(queue);
    }

    @Test
    public void creatBinding(){
        Binding binding = new Binding("hello-java-queue",
                Binding.DestinationType.QUEUE,
                "hello-java-exchange",
                "hello.java",null);
        amqpAdmin.declareBinding(binding);

    }


}
