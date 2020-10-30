package com.xian.controller;

import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import com.xian.entities.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class TalkController {

    @Autowired
    RedisTemplate<Object, MessageEntity> messageTemplate;

    @GetMapping("/talk")
    public String listEmployee(){
        return "talk/list";
    }


    @PostMapping("/talk/message")
    public String listEmployee2(MessageEntity messageEntity) {
        messageEntity.setId(1);
        messageEntity.setAdminId(2);
        UUID uuid = UUID.randomUUID();
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        messageTemplate.opsForValue().set(uuid,messageEntity);
        return "talk/list";
    }
    @GetMapping("/talk/message")
    public String listEmployee3(String string) {



        return "talk/list";
    }

}
