package com.lingxue.service.impl.generic;

import java.util.List;

/**
 *@Author 86151
 *@date 2019/12/13 15:02
 *@description 研究泛型，自主封装
 *return
 */
public interface BaseGeneric<T> {

    List<T> list(T t);
}
