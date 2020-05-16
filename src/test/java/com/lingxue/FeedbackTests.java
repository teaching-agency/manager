package com.lingxue;

import com.lingxue.controller.SysFeedbackController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.lingxue.model.util.WebUrlMappingConst.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FeedbackTests extends ManagerApplicationTests {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SysFeedbackController()).build();
    }

    @Test
    public void add() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/feedback"+ ADD_FEEDBACK)
                        .param("userId","25")
                        .param("companyId","25")
                        .param("content","第一次添加反馈")
                        .param("status","0")
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()) // 用于判断返回的期望值
                .andReturn().getResponse().getContentAsString();

    }
}
