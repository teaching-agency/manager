package com.lingxue.model.util;

import com.lingxue.model.pojo.entity.SysCompany;
import org.springframework.util.StringUtils;

/**
 *@Author Wisdom
 *@date 2019/12/17 9:04
 *@description 统一封装判断非null控制
 *return
 */
public class NotNullUtil<T,E> {

    public Boolean notNullCheck(T data,E type){

        //获取文件地址后面的“。”
        int last = data.getClass().getName().lastIndexOf(".");

        //只需要区分文件名
        String value = data.getClass().getName().substring(last+1);

        if(value.equals("SysCompany")){   //判断企业信息

            SysCompany sysCompany = (SysCompany) data;

            switch (type.toString()){
                case "registered":
                    if(StringUtils.isEmpty(sysCompany.getCompanyPhone()))
                        return true;
                    if(StringUtils.isEmpty(sysCompany.getCompanyPass()))
                        return true;
                    /*if(StringUtils.isEmpty(sysCompany.getVerifyCode()))
                        return true;*/
                    break;
                case "login":
                    if(StringUtils.isEmpty(sysCompany.getCompanyPass()))
                        return true;
                    if (StringUtils.isEmpty(sysCompany.getCompanyPhone()))
                        return true;
                    if (StringUtils.isEmpty(sysCompany.getCompanyUserIdCard()))
                        return true;
                    break;
                    default:
                        return true;
            }
        }
        return false;
    }
}
