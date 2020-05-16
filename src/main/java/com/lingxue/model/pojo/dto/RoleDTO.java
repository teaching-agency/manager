package com.lingxue.model.pojo.dto;

import com.lingxue.model.pojo.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 * 角色Dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends SysRole{
	/**
	 * 角色部门Id
	 */
	private Integer roleDeptId;

	/**
	 * 部门名称
	 */
	private String deptName;
}
