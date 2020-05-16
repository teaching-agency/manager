package com.lingxue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingxue.mapper.SysUserMapper;
import com.lingxue.model.pojo.entity.SysUser;
import com.lingxue.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService{

}
