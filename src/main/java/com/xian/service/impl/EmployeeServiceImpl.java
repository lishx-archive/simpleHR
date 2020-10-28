package com.xian.service.impl;

import com.xian.entities.EmployeeEntity;
import com.xian.mapper.EmployeeMapper;
import com.xian.service.EmployeeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("EmployeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public Collection<EmployeeEntity> getAll() {
        Collection<EmployeeEntity> employeeEntities = employeeMapper.selectList(new QueryWrapper<>());

        return  employeeEntities;

    }

    @RabbitListener(queues = {"hello-java-queue"})
    public void receiveMessage(Object message) throws InterruptedException {
        System.out.println("收到消息" + message);
        Thread.sleep(3000);
    }
}