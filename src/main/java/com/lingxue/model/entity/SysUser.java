package com.lingxue.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class SysUser extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    /**
     *用户名
     */
    @TableField("NAME")
    private String userName;

    /**
     *地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     *身份证
     */
    @TableField("ID_CODE")
    private String idCode;

    /**
     *手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     *性别:性别（F:女；M:男）默认是‘M’
     */
    @TableField("GENDER")
    private String gender;

    /**
     *用户编号
     */
    @TableField("USER_CODE")
    private String userCode;

    /**
     *小孩的姓名
     */
    @TableField("CHILDERN_NAME")
    private String childrenName;

    /**
     *附属号码
     */
    @TableField("ADJUNCT_PHONE")
    private String adjunctPhone;

    /**
     *期限（单位：月/年[默认月]）
     */
    @TableField("DEAD_LINE")
    private String deadLine;

    /**
     *加盟次数（一学期：1；寒/暑假:0.5）
     */
    @TableField("JOIN_COUNT")
    private String joinCount;

    /**
     *机构id
     */
    @TableField("COMPANY_ID")
    private Integer companyId;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
