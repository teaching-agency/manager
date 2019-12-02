package com.lingxue.model.common;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

public class MyPage<T> extends Page<T>{
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ORDER_BY_FIELD = "orderByField";
    private static final String IS_ASC = "isAsc";

    public MyPage(Map<String, Object> params) {
        Page page = new Page(Integer.parseInt(params.getOrDefault(LIMIT, 10).toString()), Integer.parseInt(params.getOrDefault(PAGE, 1).toString()));
    }
}
