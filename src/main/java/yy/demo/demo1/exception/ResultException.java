package yy.demo.demo1.exception;

import yy.demo.demo1.exception.enums.ResultEmun;

/**
 * 自定义异常类
 * @author yinmb
 * @Date 2019/1/18 17:48:21
 */
public class ResultException extends RuntimeException {
    private ResultEmun resultEmun;
    public ResultException(ResultEmun resultEmun){
        super(resultEmun.getMsg());
        this.resultEmun = resultEmun;
    }

    public ResultEmun getResultEmun() {
        return resultEmun;
    }
}
