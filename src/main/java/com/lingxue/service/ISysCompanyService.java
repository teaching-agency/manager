package com.lingxue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingxue.model.entity.SysCompany;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 *@Author Wisdom
 *@date 2019/12/16 17:54
 *@description 公司====》业务处理层
 *return
 */
public interface ISysCompanyService extends IService<SysCompany> {

    /**
     *@Author 86151
     *@Date 2019/12/17 11:02
     *Description 发送邮件  ====》业务处理层
     @Param
     *return
     */
    void sendSimpleMail(HttpServletRequest request) throws MessagingException;
}
