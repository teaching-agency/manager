package com.lingxue.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 * 部门树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {
	private String name;
}
