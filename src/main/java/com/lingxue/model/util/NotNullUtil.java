package com.lingxue.model.util;

import com.lingxue.model.entity.SysCompany;
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
                case "add":
                    if(StringUtils.isEmpty(sysCompany.getCompanyPhone()))
                        return true;
                    if(StringUtils.isEmpty(sysCompany.getCompanyPass()))
                        return true;
                    if(StringUtils.isEmpty(sysCompany.getVerifyCode()))
                        return true;
                    break;
                case "update":
                    if(StringUtils.isEmpty(sysCompany.getCompanyPass()))
                        return true;
                    break;
                    default:
                        return true;
            }
        }else if(type.equals("AuthenFilter_token")){  //判断登陆，token信息
            if (StringUtils.isEmpty(data))
                return true;
        }
        return false;
    }
}
