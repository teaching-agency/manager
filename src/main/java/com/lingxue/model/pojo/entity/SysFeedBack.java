package com.lingxue.model.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lingxue.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *@Author Wisdom
 *@date 2020/5/16 14:13
 *@description 反馈信息
 *return
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("feedback")
@Accessors(chain = true)
public class SysFeedBack extends BaseEntity implements Serializable {

    /**
     *反馈id
     */
    @TableId(value = "FEEDBACK_ID", type = IdType.AUTO)
    private Long feedbackId;

    /**
     *反馈内容
     */
    @TableField(value = "CONTENT")
    private String content;

    /**
     *用户id
     */
    @TableField(value = "USER_ID")
    private Long userId;

    /**
     *供应商名称
     */
    @TableField(value = "COMPANY_ID")
    private Long companyId;

    /**
     *图片
     */
    @TableField(value = "IMG")
    private String images;

    @TableField(value = "SOLVE_CONTENT")
    private String solveContent;

    public SysFeedBack() {

    }

    public SysFeedBack(Long feedbackId, Long userId, Long companyId, String content) {
        this.feedbackId = feedbackId;
        this.content = content;
        this.userId = userId;
        this.companyId = companyId;
    }

    public SysFeedBack(Long feedbackId, String solveContent) {
        this.feedbackId = feedbackId;
        this.solveContent = solveContent;
    }

    public SysFeedBack(Long feedbackId) {
        this.feedbackId = feedbackId;
    }
}
