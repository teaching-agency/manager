package com.lingxue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingxue.model.base.BaseController;
import com.lingxue.model.common.CommonRspVo;
import com.lingxue.model.common.MyPage;
import com.lingxue.model.constants.ResponseCodeEnum;
import com.lingxue.model.pojo.dto.feedback.AddFeedbackDTO;
import com.lingxue.model.pojo.entity.SysFeedBack;
import com.lingxue.model.util.StringUtil;
import com.lingxue.service.ISysFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.lingxue.model.util.WebUrlMappingConst.*;

/**
 *@Author Wisdom
 *@date 2020/5/16 14:45
 *@description 反馈controller层；严格遵循resultful风格
 *return
 */
@RestController
@RequestMapping("/feedback")
public class SysFeedbackController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysFeedbackController.class);

    @Autowired
    private ISysFeedbackService iSysFeedbackService;

    // 配置管理员
    @Value("${customize.defaultUserId}")
    private String admin;

    /**
     *@Author 86151
     *@Date 2020/5/16 16:12
     *Description 新增反馈信息
     * * @param  : addFeedbackDTO
     * * @return : com.lingxue.model.common.CommonRspVo<java.lang.Boolean>
     */
    @PostMapping(value = ADD_FEEDBACK)
    public CommonRspVo<Boolean> saveFeedback(AddFeedbackDTO addFeedbackDTO){
        LOGGER.info("成功进入新增反馈信息接口，名称" + "");

        Boolean b = StringUtil.isEmpty(String.valueOf(addFeedbackDTO.getUserId())) || StringUtil.isEmpty(String.valueOf(addFeedbackDTO.getCompanyId()));

        if (b) {
            return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_NULL);
        }

        try {
            SysFeedBack sysFeedBack = new SysFeedBack();
            addFeedbackDTO.setStatus("0");
            BeanUtils.copyProperties(addFeedbackDTO,sysFeedBack);
            return new CommonRspVo<>(iSysFeedbackService.save(sysFeedBack));
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            LOGGER.error("接口异常");
            return new CommonRspVo<>(false,ResponseCodeEnum.SYSTEM_ERROR);
        }
    }

    /**
     *@Author 86151
     *@Date 2020/5/16 16:15
     *Description 删除反馈信息,2(已解决)；3（未解决）状态下不准删除
     * * @param  : sysFeedBack
     * * @return : com.lingxue.model.common.CommonRspVo<java.lang.Boolean>
     */
    @DeleteMapping(value = DELETE_FEEDBACK)
    public CommonRspVo<Boolean> removeFeedback(Long feedbackId) {
        LOGGER.info("成功进入删除反馈信息接口，名称" + "");

        SysFeedBack sysFeedBack = new SysFeedBack();

        Boolean b = StringUtil.isEmpty(String.valueOf(feedbackId));

        if (b) {
            return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_NULL);
        }
        // 获取此条反馈信息，判断status为2是已解决状态;status为3是已解决状态，不能删除
        sysFeedBack = iSysFeedbackService.getById(feedbackId);

        if ("2".equals(sysFeedBack.getStatus()) || "3".equals(sysFeedBack.getStatus())) {
            return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_STASTUS);
        }
        return new CommonRspVo<>(iSysFeedbackService.removeById(feedbackId));
    }

    /**
     *@Author 86151
     *@Date 2020/5/16 16:30
     *Description 更新反馈信息：
     *                 ①：用户本身更新
     *                 ②管理员更新：更新状态，若解决加内容
     *
     * * @return : com.lingxue.model.common.CommonRspVo<java.lang.Boolean>
     */
    @PutMapping(value = UPDATE_FEEDBACK)
    public CommonRspVo<Boolean> updateFeedback(SysFeedBack sysFeedBack){
        LOGGER.info("成功进入修改反馈方法中！！！");
        SysFeedBack sysFeedBack1 = new SysFeedBack();
        // 获取此条反馈信息，判断status为2是已解决状态;status为3是已解决状态，不能修改
        sysFeedBack1 = iSysFeedbackService.getById(sysFeedBack.getFeedbackId());

        // 若是管理员必传status与resolveContent
        if (admin.equals(sysFeedBack.getUserId())) {
            Boolean b = StringUtil.isEmpty(sysFeedBack.getSolveContent()) || StringUtil.isEmpty(sysFeedBack.getStatus());
            if (b) {
                return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_NULL);
            }
            // "2";"3"不准修改
            if ("2".equals(sysFeedBack1.getStatus()) || "3".equals(sysFeedBack1.getStatus())) {
                return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_STASTUS);
            }
            return new CommonRspVo<>(iSysFeedbackService.updateById(sysFeedBack));
        }
        // 用户本身修改
        Boolean b = StringUtil.isEmpty(String.valueOf(sysFeedBack.getUserId())) || StringUtil.isEmpty(String.valueOf(sysFeedBack.getCompanyId()));
        if (b) {
            return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_NULL);
        }

        // "2";"3"不准修改
        if ("2".equals(sysFeedBack1.getStatus()) || "3".equals(sysFeedBack1.getStatus())) {
            return new CommonRspVo<>(false, ResponseCodeEnum.SYSTEM_ERROR_STASTUS);
        }

        return new CommonRspVo<>(iSysFeedbackService.updateById(sysFeedBack));
    }

    /**
     *@Author Wisdom
     *@date 2020/5/16 16:51
     *@description 分页获取数据
     *return
     */
    @GetMapping(value = GET_PAGE_FEEDBACK)
    public IPage<SysFeedBack> getFeedbackByPage(@RequestParam Map<String, Object> map) {
        LOGGER.info("成功进入查询分页的方法！！！！");
        return iSysFeedbackService.page(new MyPage<>(map));
    }
}
