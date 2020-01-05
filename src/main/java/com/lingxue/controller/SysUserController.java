package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.constants.ResponseCodeEnum;
import com.lingxue.model.entity.SysUser;
import com.lingxue.model.util.StringUtil;
import com.lingxue.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.lingxue.model.util.WebUrlMappingConst.*;

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
    @GetMapping(value = URL_USER_INFO + "/{id}")
    public CommonRspVo<SysUser> get(@PathVariable String id) {
        //判断传过来的值是否存在
        if (StringUtil.isEmpty(id))
            return new CommonRspVo<>(null, ResponseCodeEnum.SYSTEM_ERROR_NULL);
        return new CommonRspVo<>(sysUserService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping(value = URL_USER_PAGE)
    public IPage<SysUser> page(@RequestParam Map<String, Object> params) {
        return sysUserService.page(new MyPage<>(params));
    }

    /**
     * 添加
     * @param  sysUser  实体
     * @return success/false
     */
    @PostMapping(URL_USER_ADD)
    public CommonRspVo<Boolean> add(@RequestBody SysUser sysUser) {
        return new CommonRspVo<>(sysUserService.save(sysUser));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping(value = URL_USER_DELETE + "/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysUser sysUser = new SysUser();
        return new CommonRspVo<>(sysUserService.updateById(sysUser));
    }

    /**
     * 编辑
     * @param  sysUser  实体
     * @return success/false
     */
    @PutMapping(value = URL_USER_UPDATE)
    public CommonRspVo<Boolean> edit(@RequestBody SysUser sysUser) {
        return new CommonRspVo<>(sysUserService.updateById(sysUser));
    }

    /**
     *@Author 86151
     *@Date 2020/1/5 21:57
     *Description 导出家长资料
     * * @param  : sysUser
     * * @return : com.lingxue.model.common.CommonRspVo<java.lang.Boolean>
     */
    @PostMapping(value = URL_USER_EXPORT)
    public CommonRspVo<Boolean> exportUser(@RequestBody SysUser sysUser){
        return null;
    }

    /**
     *@Author 86151
     *@Date 2020/1/5 21:59
     *Description 导入用户信息（无：新增；有：编辑）
     * * @param  : sysUser
     * * @return : com.lingxue.model.common.CommonRspVo<java.lang.Boolean>
     */
    @PostMapping(value = URL_USER_IMPORT)
    public CommonRspVo<Boolean> importUser(@RequestBody SysUser sysUser){
        return null;
    }
}
