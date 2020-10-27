package com.xian.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("employee")
public class EmployeeEntity implements Serializable {
    @TableId
	private Integer id;
    private String name;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Integer departmentId;
    private Date birth;


}
