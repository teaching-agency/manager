package com.lingxue.model.util;

import com.lingxue.model.pojo.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author Wisdom
 *@date 2020/5/16 12:21
 *@description 树形封装方法
 *return
 */
@SuppressWarnings("unchecked")
public class TreeNodeUtils<T extends TreeNode> {

    /**
     *@Author 86151
     *@Date 2020/5/16 12:30
     *Description 获取树形结构
     *             默认最高级parentId=null;,通过id与parentId进行子级对应存于children属性中。
     * * @param  : list
     * * @return : java.util.List<T>
     */
    public List<T> getTreeData(List<T> list) {
        List <T> tList = new ArrayList<>();
        for (T t : list) {
            if (StringUtil.isEmpty(String.valueOf(t.getId()))) {
                tList.add(t);
            }
        }
        for (T t : tList) {
            List<T> ts = new ArrayList<>();
            ts = getChildrenTree(t, list);
            t.setChildren((List<TreeNode>) ts);
        }
        return tList;
    }

    private List<T> getChildrenTree(T m, List<T> list) {
        List<T> ts = new ArrayList<>();
        for (T t : list) {
            if (m.getId().equals(t.getParentId())) {
                m.setChildren((List<TreeNode>) ts);
            }
            ts = getChildrenTree(t, list);
        }
        return ts;
    }
}
