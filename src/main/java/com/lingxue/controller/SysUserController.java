package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.entity.SysUser;
import com.lingxue.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysUser
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysUser> get(@PathVariable String id) {
        return new CommonRspVo<>(sysUserService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysUser> page(@RequestParam Map<String, Object> params) {
        return sysUserService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysUser  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysUser sysUser) {
        return new CommonRspVo<>(sysUserService.save(sysUser));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysUser sysUser = new SysUser();
        return new CommonRspVo<>(sysUserService.updateById(sysUser));
    }

    /**
     * 编辑
     * @param  sysUser  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysUser sysUser) {
        return new CommonRspVo<>(sysUserService.updateById(sysUser));
    }
}
