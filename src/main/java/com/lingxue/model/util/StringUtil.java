package com.lingxue.model.util;

import java.io.UnsupportedEncodingException;

/**
 *@Author Wisdom
 *@date 2019/12/25 14:01
 *@description 校验String的各种传值方式
 *return
 */
public class StringUtil {

    /**
     *默认字体格式UTF-8
     */
    private static final String CHARSET_NAME = "UTF-8";

    /**
     *@Author 86151
     *@Date 2019/12/25 15:18
     *Description
     * * @param  : str
     * * @return : boolean
     */
    public static final boolean isEmpty(String str){
        return (str == null || str.trim().length() == 0 || "null".equals(str.trim()) || str == "");
    }

    /**
     *@Author 86151
     *@Date 2019/12/25 15:19
     *Description 用with替换text中有的boxString
     * * @param  : text * @param  : boxString * @param  : with
     * * @return : java.lang.String
     */
    public static final String betweenReplace(String text, String boxString, String with){
        if (text == null || boxString == null || with == null || boxString.length() == 0){
            return text;
        }

        StringBuffer sb = new StringBuffer(text.length());

        int start = 0, end = 0;

        while ((end = text.indexOf(boxString, start)) != -1){
            sb.append(text.substring(start,end));

            sb.append(with);

            start = end + boxString.length();

            end = text.indexOf(boxString,start);

            if (end == -1){
                return sb.toString();
            }
        }
        //没有就返回原来text
        sb.append(text.substring(start));

        return sb.toString();
    }

    /**
     *@Author 86151
     *@Date 2019/12/25 16:45
     *Description 首字母大写
     * * @param  : str
     * * @return : java.lang.String
     */
    public static final String toUpperCaseTop(String str){
        if (str == null)
            return null;
        if (str == "")
            return "";

        StringBuffer sb = new StringBuffer();

        sb.append(str.toUpperCase().charAt(0));
        sb.append(str.substring(1));

        return sb.toString();
    }

    /**
     *@Author 86151
     *@Date 2019/12/25 16:48
     *Description 首字母小写
     * * @param  : str
     * * @return : java.lang.String
     */
    public static final String toLowerCaseTop(String str){
        if (str == null)
            return null;
        if (str == "")
            return "";

        StringBuffer sb = new StringBuffer();

        sb.append(str.toLowerCase().charAt(0));
        sb.append(str.substring(1));

        return sb.toString();
    }

    /**
     *@Author 86151
     *@Date 2019/12/25 16:59
     *Description 获取字符串的长度，""默认为0；null会报空指针
     * * @param  : str
     * * @return : int
     */
    public static int getByteLength(String str){
        if (str == null)
            return 0;
        try {
            return str.getBytes(CHARSET_NAME).length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }

    /**
     *@Author 86151
     *@Date 2019/12/25 17:16
     *Description 正则：仅去除开头空格:"^\\s";去除所有空格:"\\s"
     * * @param  : str
     * * @return : java.lang.String
     */
    public static String ltrim(String str){
        if (str == null)
            return null;

        return str.replaceAll("\\s",str);
    }
    
    /**
     *@Author 86151
     *@Date 2019/12/25 17:30
     *Description 将字节码按照utf-8格式换成字节进行拼装
     * * @param  : str
     * * @return : java.lang.String
     */
    public static String stringToByte(String str){
        byte[] b = null;

        try {
            //获取字节
            b = str.getBytes(CHARSET_NAME);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();

        for (byte bb : b){
            sb.append(bb).append("/");
        }
        
        return sb.toString();
    }
}
