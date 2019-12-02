package com.lingxue.model.common;

import com.lingxue.model.constants.ResponseCodeEnum;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CommonRspVo<T> implements Serializable {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public CommonRspVo(){ }

    public CommonRspVo(ResponseCodeEnum code){
        this.code=code.getCode();
        this.message=code.getMessage();
    }
    public CommonRspVo(T data,ResponseCodeEnum code){
        this.code=code.getCode();
        this.message=code.getMessage();
        this.data=data;
    }
    public CommonRspVo(T data){
        this(ResponseCodeEnum.SUCCESS);
        this.data=data;
    }

    /**
     * 判断是否成功
     * @return
     */
    public boolean successfull(){
        return ResponseCodeEnum.SUCCESS.getCode().equals(this.code);
    }

    /**
     * 获取成功对象
     * @param data
     * @param <C>
     * @return
     */
    public  static <C> CommonRspVo  success(C data){
        CommonRspVo success=new CommonRspVo(ResponseCodeEnum.SUCCESS);
        success.data=data;
        return success;
    }

    /**
     * 获取失败对象
     * @return
     */
    public  static  CommonRspVo  faild(){
        CommonRspVo faild=new CommonRspVo(ResponseCodeEnum.SYSTEM_ERROR);
        return faild;
    }
}
