package com.lingxue.model.constants;


public enum ResponseCodeEnum {
    /**
     * 操作成功
     */
    SUCCESS("0000","SUCCESSFULL!"),
    /**
     * 系统异常，可在9000---9998之间添加详细系统异常码
     */
    SYSTEM_ERROR("9999","SYSTEM ERROR!"),
    /**
     * mysql 相关错误，可在8000---9000添加详细错误码
     */
    MYSQL_ERROR("8000","MYSQL ERROR!"),
    /**
     * mongodb 错误，可在7000-8000之间添加详细错误码
     */
    MONGODB_ERROR("7000","MONGO ERROR!"),
    /**
     * redis相关错误，可在6000----7000之间添加详细错误码
     */
    REDIS_ERROR("6000","REDIS ERROR");
    /**
     * 错误码
     */
    private final String code;
    /**
     * 错误描述
     */
    private final String message;
    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
