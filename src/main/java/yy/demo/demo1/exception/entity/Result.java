package yy.demo.demo1.exception.entity;

import lombok.Data;
import yy.demo.demo1.exception.enums.ResultEmun;

/**
 * @author yinmb
 * @Date 2019/1/22 14:58:14
 */
@Data
public class  Result {
    private String code;
    private String msg;
    private Object date;

    public Result(ResultEmun resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(ResultEmun resultEmun, Object object) {
        this(resultEmun);
        this.msg = msg;
    }
}
