package com.lingxue.model.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lingxue.model.base.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *@Author Wisdom
 *@date 2019/12/16 11:19
 *@description 公司相关信息，所用功能都通过公司往下分配
 *return
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("company")
@Accessors(chain = true)
public class SysCompany extends BaseEntity {

    /**
     *公司id
     */
    @TableId(value = "COMPANY_ID", type = IdType.AUTO)
    private Long companyId;

    /**
     *公司名称
     */
    @TableField(value = "COMPANY_NAME")
    private String companyName;

    /**
     *地址
     */
    @TableField(value = "ADDRESS")
    private String address;

    /**
     *法人姓名
     */
    @TableField("LEGAL_PERSION_NAME")
    private String legalPersionName;

    /**
     *手机号
     */
    @TableField("COMPANY_PHONE")
    private String companyPhone;

    /**
     *座机
     */
    @TableField("LAND_LINE")
    private String landLine;

    /**
     *期限
     */
    @TableField("DEAD_LINE")
    private String deadLine;

    /**
     *每月结账时间
     */
    @TableField("BILL_TIME")
    private Date billTime;

    /**
     *加盟次数（月按0.几算）
     */
    @TableField("JOIN_COUNT")
    private String joinCount;

    /**
     *token令牌
     */
    @TableField("TOKEN")
    private String token;

    /**
     *密码
     */
    @TableField("COMPANY_PASS")
    private String companyPass;

    /**
     *法人身份证号
     */
    @TableField("COMPANY_USER_ID_CARD")
    private String companyUserIdCard;

    /**
     *验证码：只做用户注册一次使用，不加以保存
     */
    private String verifyCode;

    @Override
    protected Serializable pkVal() {
        return this.companyId;
    }
}
