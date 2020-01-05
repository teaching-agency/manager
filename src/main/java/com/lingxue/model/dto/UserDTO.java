package com.lingxue.model.dto;

import com.lingxue.model.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser{
	/**
	 * 角色ID
	 */
	private List<Integer> role;

	private Integer deptId;

	/**
	 * 新密码
	 */
	private String newpassword1;
}
