package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.entity.SysRole;
import com.lingxue.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysRole
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysRole> get(@PathVariable String id) {
        return new CommonRspVo<>(sysRoleService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysRole> page(@RequestParam Map<String, Object> params) {
        return sysRoleService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysRole  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysRole sysRole) {
        return new CommonRspVo<>(sysRoleService.save(sysRole));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysRole sysRole = new SysRole();
        return new CommonRspVo<>(sysRoleService.updateById(sysRole));
    }

    /**
     * 编辑
     * @param  sysRole  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysRole sysRole) {
        return new CommonRspVo<>(sysRoleService.updateById(sysRole));
    }
}
