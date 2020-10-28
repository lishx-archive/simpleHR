package com.xian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xian.entities.AdminEntity;
import com.xian.entities.EmployeeEntity;

import java.util.Collection;

/**
 * 会员
 *
 * @author lishouxian
 * @email li.shouxian@outlook.com
 * @date 2020-10-27 09:21:29
 */
public interface AdminService extends IService<AdminEntity> {


    Collection<AdminEntity> getAll();


}

