package com.lingxue.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author zhenghaiyang
 * @since 2019-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_menu")
public class SysRoleMenu extends Model<SysRoleMenu>{

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("role_id")
    private Integer roleId;
    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Integer menuId;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
