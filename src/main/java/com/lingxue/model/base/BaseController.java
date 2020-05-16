package com.lingxue.model.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *@Author Wisdom
 *@date 2020/5/16 14:04
 *@description 抽象类继承
 *return
 */
public abstract class BaseController {
    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;
}
