package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.constants.ResponseCodeEnum;
import com.lingxue.model.pojo.entity.SysDict;
import com.lingxue.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@RestController
@RequestMapping("/sys-dict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysDict
    */
    @GetMapping("/{id}")
    public CommonRspVo<SysDict> get(@PathVariable String id) {
        return new CommonRspVo<>(sysDictService.getById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public IPage<SysDict> page(@RequestParam Map<String, Object> params) {
        return sysDictService.page(new MyPage<>(params), Wrappers.emptyWrapper());
    }

    /**
     * 添加
     * @param  sysDict  实体
     * @return success/false
     */
    @PostMapping
    public CommonRspVo<Boolean> add(@RequestBody SysDict sysDict) {
        //默认判断是操作成功
        if(!sysDictService.save(sysDict)){
            return new CommonRspVo<>(sysDictService.save(sysDict),ResponseCodeEnum.SYSTEM_ERROR);
        }
        return new CommonRspVo<>(sysDictService.save(sysDict));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public CommonRspVo<Boolean> delete(@PathVariable String id) {
        SysDict sysDict = new SysDict();
        CommonRspVo commonRspVo=new CommonRspVo();

        return new CommonRspVo<>(sysDictService.updateById(sysDict));
    }

    /**
     * 编辑
     * @param  sysDict  实体
     * @return success/false
     */
    @PutMapping
    public CommonRspVo<Boolean> edit(@RequestBody SysDict sysDict) {
        return new CommonRspVo<>(sysDictService.updateById(sysDict));
    }
}
