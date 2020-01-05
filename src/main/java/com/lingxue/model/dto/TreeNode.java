package com.lingxue.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 */
@Data
public class TreeNode {
	protected int id;
	protected int parentId;
	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
