package com.lingxue.model.filter;

import com.lingxue.model.entity.SysCompany;
import com.lingxue.model.util.JwtUtil;
import com.lingxue.model.util.NotNullUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lingxue.model.constants.CommonConstant.Login_Company_Key;
import static com.lingxue.model.constants.CommonConstant.Token_EncryKey;

/**
 *@Author Wisdom
 *@date 2019/12/22 17:05
 *@description 过滤器验证用户授权token
 *return
 */
@WebFilter
public class AuthenFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //引进判空类
        NotNullUtil<String,String> notNullUtil = new NotNullUtil<>();

        try {
            //只接受post
            if(!request.getMethod().equalsIgnoreCase("post")){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }

            //获取token
            String token = request.getHeader("token");

            //判断是否为null
            if (notNullUtil.notNullCheck(token,"AuthenFilter_token")){
                LOGGER.info("无token");
                return;
            }

            //jwt验证
            SysCompany sysCompany = JwtUtil.getValByT(token,Token_EncryKey, Login_Company_Key,SysCompany.class);

            //校验
            if (sysCompany == null){
                LOGGER.info("token已经失效");
                return;
            }

            filterChain.doFilter(servletRequest,servletResponse);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
