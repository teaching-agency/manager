package com.lingxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingxue.model.pojo.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
public interface SysRoleMapper extends BaseMapper<SysRole>{

    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> listRolesByUserId(Integer userId);
}
