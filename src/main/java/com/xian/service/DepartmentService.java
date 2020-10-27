package com.xian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.entities.DepartmentEntity;

import java.util.Collection;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/27 15:03
 * @Description:
 */
public interface DepartmentService extends IService<DepartmentEntity> {

    Collection<DepartmentEntity> getall();
}
