package com.lingxue.model.pojo.dto.feedback;

import com.lingxue.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddFeedbackDTO extends BaseEntity {

    // 用户id
    private Long userId;

    // 公司id
    private Long companyId;

    // 内容
    private String content;

    // 图片
    private String images;

}
