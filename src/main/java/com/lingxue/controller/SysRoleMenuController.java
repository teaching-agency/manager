package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.entity.SysRoleMenu;
import com.lingxue.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 角色菜单表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-role-menu")
public class SysRoleMenuController {

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysRoleMenu
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysRoleMenu> get(@PathVariable String id) {
        return new CommonRspVo<>(sysRoleMenuService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysRoleMenu> page(@RequestParam Map<String, Object> params) {
        return sysRoleMenuService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysRoleMenu  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysRoleMenu sysRoleMenu) {
        return new CommonRspVo<>(sysRoleMenuService.save(sysRoleMenu));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        return new CommonRspVo<>(sysRoleMenuService.updateById(sysRoleMenu));
    }

    /**
     * 编辑
     * @param  sysRoleMenu  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysRoleMenu sysRoleMenu) {
        return new CommonRspVo<>(sysRoleMenuService.updateById(sysRoleMenu));
    }
}
