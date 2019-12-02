package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.entity.SysUserRole;
import com.lingxue.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysUserRole
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysUserRole> get(@PathVariable String id) {
        return new CommonRspVo(sysUserRoleService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysUserRole> page(@RequestParam Map<String, Object> params) {
        return sysUserRoleService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysUserRole  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysUserRole sysUserRole) {
        return new CommonRspVo<>(sysUserRoleService.save(sysUserRole));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysUserRole sysUserRole = new SysUserRole();
        return new CommonRspVo<>(sysUserRoleService.updateById(sysUserRole));
    }

    /**
     * 编辑
     * @param  sysUserRole  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysUserRole sysUserRole) {
        return new CommonRspVo<>(sysUserRoleService.updateById(sysUserRole));
    }
}
