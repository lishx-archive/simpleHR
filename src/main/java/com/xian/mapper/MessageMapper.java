package com.xian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xian.entities.AdminEntity;
import com.xian.entities.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/30 21:24
 * @Description:
 */

@Mapper
public interface MessageMapper  extends BaseMapper<MessageEntity> {

}
