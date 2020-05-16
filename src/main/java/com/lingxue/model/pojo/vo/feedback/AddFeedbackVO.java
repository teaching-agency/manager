package com.lingxue.model.pojo.vo.feedback;

import com.lingxue.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *@Author Wisdom
 *@date 2020/5/16 14:27
 *@description 新增反馈信息
 *return
 */
@SuppressWarnings("seria")
@Setter
@Getter
public class AddFeedbackVO extends BaseEntity {

    // 反馈id
    private  Long feedbackId;

    // 用户id
    private Long userId;

    // 公司id
    private Long companyId;

    // 内容
    private String content;

    // 图片
    private String images;

    // 解决办法反馈
    private String solveContent;
}
