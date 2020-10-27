package com.xian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xian.entities.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/27 13:43
 * @Description:
 */

@Mapper
public interface DepartmentMapper extends BaseMapper<DepartmentEntity> {
}
