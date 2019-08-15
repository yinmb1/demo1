package yy.demo.demo1.exception.enums;

import lombok.Data;

/**
 * 处理枚举
 * @author yinmb
 * @Date 2019/1/18 18:02:39
 */
public enum ResultEmun {
    /**
     * 请求错误
     */
    RESP_ERROR("111111", "请求错误");

    private String code;
    private String msg;


    ResultEmun(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
