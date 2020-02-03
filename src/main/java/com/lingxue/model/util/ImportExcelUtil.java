package com.lingxue.model.util;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *@Author Wisdom
 *@date 2020/1/6 15:14
 *@description 导入功能
 *return
 */
public class ImportExcelUtil {

    /**
     25      * @param in           ：承载着Excel的输入流
     26      * @param ：要导入的工作表序号
     27      * @param entityClass  ：List中对象的类型（Excel中的每一行都要转化为该类型的对象）
     28      * @param fieldMap     ：Excel中的中文列头和类的英文属性的对应关系Map
     29      * @param uniqueFields ：指定业务主键组合（即复合主键），这些列的组合不能重复
     30      * @return ：List
     31      * @throws ExcelException
     32      * @MethodName : excelToList
     33      * @Description : 将Excel转化为List
     34      */
    public static <T> List<T> excelToList(InputStream in, String sheetName, Class<T> entityClass, LinkedHashMap<String, String> fieldMap, String[] uniqueFields){


        return null;
    }
}
