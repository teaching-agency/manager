package com.lingxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingxue.model.pojo.entity.SysMenu;
import com.lingxue.model.pojo.vo.MenuVO;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
public interface SysMenuMapper extends BaseMapper<SysMenu>{

    /**
     * 通过角色编号查询菜单
     *
     * @param roleId 角色ID
     * @return
     */
    List<MenuVO> listMenusByRoleId(Integer roleId);

    /**
     * 通过角色ID查询权限
     *
     * @param roleIds Ids
     * @return
     */
    List<String> listPermissionsByRoleIds(String roleIds);
}
