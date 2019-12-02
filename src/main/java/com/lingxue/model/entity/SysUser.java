package com.lingxue.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
@TableName("sys_user")
public class SysUser extends Model<SysUser>{

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    private String password;
    /**
     * 随机盐
     */
    private String salt;
    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 0-正常，9-锁定
     */
    @TableField("lock_flag")
    private String lockFlag;
    /**
     * 0-正常，1-删除
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 微信openid
     */
    @TableField("wx_openid")
    private String wxOpenid;
    /**
     * QQ openid
     */
    @TableField("qq_openid")
    private String qqOpenid;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
