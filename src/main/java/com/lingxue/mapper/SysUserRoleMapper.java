package com.lingxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingxue.model.pojo.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole>{

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    Boolean deleteByUserId(@Param("userId") Integer userId);
}
