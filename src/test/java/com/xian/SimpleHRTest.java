package com.xian;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import com.xian.service.DepartmentService;
import com.xian.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@MapperScan("com.xian.mapper")
@SpringBootTest
class SimpleHRTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;


    @Test
    void contextLoads() {
//        List<Map<String, Object>> maps = departmentService.listMaps(new QueryWrapper<>());
        Collection<DepartmentEntity> departments = departmentService.getall();
        Map<Integer,String> maps = new HashMap<>();
        for (DepartmentEntity depart : departments) {
            maps.put(depart.getId(),depart.getDepName());
        }
        System.out.println(maps);
    }

}
