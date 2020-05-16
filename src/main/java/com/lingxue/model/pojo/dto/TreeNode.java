package com.lingxue.model.pojo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghaiyang
 * @since 2020-01-05
 */
@Data
public class TreeNode {
	protected Integer id;
	protected Integer parentId;
	protected List<TreeNode> children = new ArrayList<>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
