package com.xian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.entities.AdminEntity;
import com.xian.entities.DepartmentEntity;
import com.xian.mapper.AdminMapper;
import com.xian.mapper.DepartmentMapper;
import com.xian.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/27 15:04
 * @Description:
 */
@Service("AdminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Collection<AdminEntity> getAll() {
        Collection<AdminEntity> AdminEntity = adminMapper.selectList(new QueryWrapper<>());

        return  AdminEntity;
    }
}
