package com.lingxue.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
/**
 *@Author Wisdom
 *@date 2019/12/16 11:18
 *@description 基本实体参封装
 *return
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Accessors(chain = true)
public abstract class BaseEntity extends Model<BaseEntity>{

    @TableField(value = "CREATE_TIME")
    private Date createTime;

    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    @TableField(value = "END_TIME")
    private Date endTime;

    @TableField(value = "STATUS")
    private String status;

}
