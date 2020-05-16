package com.lingxue.model.util;

/**
 *@Author Wisdom
 *@date 2019/12/22 18:48
 *@description 接口统一规范输写
 *return
 */
public class WebUrlMappingConst {

    public WebUrlMappingConst() {
    }

    /**
     *企业信息
     */
    private static final String URL_COMPANY = "/company/";

    public static final String URL_COMPANY_LOGIN = URL_COMPANY + "login";  //登陆

    public static final String URL_COMPANY_REGISTERED = URL_COMPANY + "registered";  //注册

    /**
     *加盟用户
     */
    private static final String URL_USER = "/user/";

    public static final String URL_USER_INFO = URL_USER + "info";  //用户信息

    public static final String URL_USER_PAGE = URL_USER + "page";  //分页

    public static final String URL_USER_ADD = URL_USER + "add";  //添加

    public static final String URL_USER_UPDATE = URL_USER + "update";   //编辑

    public static final String URL_USER_DELETE = URL_USER + "delete";   //删除

    public static final String URL_USER_EXPORT = URL_USER + "export"; //用户数据导出

    public static final String URL_USER_IMPORT = URL_USER + "import";  //用户导入功能

    /**
     *反馈信息
     */
    private static final String FEEDBACK = "/feedback";

    public static final String ADD_FEEDBACK =  "/add" + FEEDBACK ; //新增反馈

    public static final String DELETE_FEEDBACK =  "/delete" + FEEDBACK ; //删除反馈

    public static final String UPDATE_FEEDBACK =  "/update" + FEEDBACK ; //更改反馈

    public static final String GET_PAGE_FEEDBACK =  "/getPageBy" + FEEDBACK ; //更改反馈
}
