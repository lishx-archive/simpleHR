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
@TableName("admin")
public class AdminEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String adminName;
    private String password;

}
