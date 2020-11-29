package com.lingxue.model.pojo.dto;

import com.lingxue.model.pojo.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 * <p>
 * commit('SET_ROLES', data)
 * commit('SET_NAME', data)
 * commit('SET_AVATAR', data)
 * commit('SET_INTRODUCTION', data)
 * commit('SET_PERMISSIONS', data)
 */
@Data
public class UserInfo implements Serializable {
	/**
	 * 用户基本信息
	 */
	private SysUser sysUser;
	/**
	 * 权限标识集合
	 */
	private String[] permissions;

	/**
	 * 角色集合
	 */
	private Integer[] roles;
}