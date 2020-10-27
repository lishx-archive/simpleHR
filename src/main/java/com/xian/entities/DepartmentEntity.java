package com.xian.entities;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;
	private String depName;


}
