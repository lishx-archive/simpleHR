package com.xian;

import com.xian.entities.MessageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/30 21:09
 * @Description:
 */

@SpringBootTest
public class RedisTesT {
//    @Autowired
//    MessageMapper messageMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的

    @Autowired
    RedisTemplate<Object, MessageEntity> messageTemplate;

    @Test
    public void test02(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(1);
        messageEntity.setAdminId(2);
        messageEntity.setMsg("你好");
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        messageTemplate.opsForValue().set("msg-01",messageEntity);

    }



}
