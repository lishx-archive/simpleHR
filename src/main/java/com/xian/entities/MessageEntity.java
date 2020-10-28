package com.xian.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lishouxian
 * @Date: 2020/10/28 15:15
 * @Description:
 */

@Data
@TableName("message")
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private Integer adminId;
    private String msg;
    private Data data;


}
