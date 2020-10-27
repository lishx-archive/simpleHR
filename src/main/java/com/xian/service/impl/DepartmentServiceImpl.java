package com.xian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import com.xian.mapper.DepartmentMapper;
import com.xian.mapper.EmployeeMapper;
import com.xian.service.DepartmentService;
import com.xian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/27 15:04
 * @Description:
 */
@Service("DepartmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentEntity> implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Collection<DepartmentEntity> getall() {
        Collection<DepartmentEntity> departmentEntities = departmentMapper.selectList(new QueryWrapper<>());

        return  departmentEntities;
    }
}
