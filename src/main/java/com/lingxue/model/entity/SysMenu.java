package com.lingxue.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class SysMenu extends Model<SysMenu>{

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "MENU_ID", type = IdType.AUTO)
    private Integer menuId;
    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String name;
    /**
     * 菜单权限标识
     */
    @TableField("PERMISSION")
    private String permission;
    /**
     * 前端URL
     */
    @TableField("URL")
    private String path;
    /**
     * 父菜单ID
     */
    @TableField("PARENT_ID")
    private Integer parentId;
    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;
    /**
     * VUE页面
     */
    @TableField(exist = false)
    private String component;
    /**
     * 排序值
     */
    @TableField(exist = false)
    private Integer sort;
    /**
     * 0-开启，1- 关闭
     */
    @TableField(value = "keep_alive",exist = false)
    private String keepAlive;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    @TableField(exist = false)
    private String type;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;
    /**
     * 逻辑删除标记(0--正常 1--删除)
     */
    @TableField("DEL_FLAG")
    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
