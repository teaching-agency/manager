package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.pojo.entity.SysMenu;
import com.lingxue.service.ISysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private ISysMenuService sysMenuService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysMenu
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysMenu> get(@PathVariable String id) {
        return new CommonRspVo<>(sysMenuService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysMenu> page(@RequestParam Map<String, Object> params) {
        LOGGER.info("成功进入mennus！！！！");
        return sysMenuService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysMenu  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysMenu sysMenu) {
        return new CommonRspVo<>(sysMenuService.save(sysMenu));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysMenu sysMenu = new SysMenu();
        return new CommonRspVo<>(sysMenuService.updateById(sysMenu));
    }

    /**
     * 编辑
     * @param  sysMenu  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysMenu sysMenu) {
        return new CommonRspVo<>(sysMenuService.updateById(sysMenu));
    }
}
