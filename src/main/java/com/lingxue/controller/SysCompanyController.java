package com.lingxue.controller;

import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.constants.ResponseCodeEnum;
import com.lingxue.model.entity.SysCompany;
import com.lingxue.model.util.NotNullUtil;
import com.lingxue.service.ISysCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author Wisdom
 *@date 2019/12/16 17:46
 *@description 公司业务===》controller层
 *return
 */
@RestController
@RequestMapping("sys_company")
public class SysCompanyController {

    @Autowired
    ISysCompanyService iSysCompanyService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SysCompanyController.class);

    /**
     *@Author 86151
     *@Date 2019/12/16 19:36
     *Description 公司用户=======》新增
     @Param
     *return
     */
    @PostMapping(value = "add")
    public CommonRspVo<Boolean> CompanyAdd(@RequestBody SysCompany sysCompany){
        LOGGER.info("成功进入公司添加接口！！！");

        NotNullUtil<SysCompany,String> notNullUtil = new NotNullUtil<>();

        //判断必传值不能为null
        if(notNullUtil.notNullCheck(sysCompany,"add"))
            return new CommonRspVo<>(false,ResponseCodeEnum.SYSTEM_ERROR_NULL);

        //默认判断是操作成功
        try {
            return new CommonRspVo<>(iSysCompanyService.save(sysCompany));
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            LOGGER.error("接口异常");
        }
        return new CommonRspVo<>(false,ResponseCodeEnum.SYSTEM_ERROR);
    }
}
