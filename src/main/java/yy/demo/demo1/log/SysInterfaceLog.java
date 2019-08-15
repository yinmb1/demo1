package yy.demo.demo1.log;


import lombok.Data;

import java.util.Date;

/**
 * 接口日志实体
 * @author yinmb
 * @date 2018/01/11
 */
@Data
public class SysInterfaceLog {
    /**
     * 序号
     */
    private String id;
    /**
     * 访问路径
     */
    private String url;
    /**
     *访问平台
     */
    private String platform;
    /**
     *请求头
     */
    private String requestHeader;
    /**
     *请求体
     */
    private String requestBody;
    /**
     *请求时间
     */
    private Date requestTime;
    /**
     *响应头
     */
    private String responseHeader;
    /**
     *响应体
     */
    private String responseBody;
    /**
     *响应时间
     */
    private Date responseTime;
    /**
     *返回码
     */
    private String code;
    /**
     *返回信息
     */
    private String msg;
    /**
     *接口耗时
     */
    private long consumeTime;
    /**
     *接口编号
     */
    private String interfaceNo;
    /**
     *身份证
     */
    private String certId;
    /**
     *申请编号
     */
    private String applyNo;
    /**
     *借据号
     */
    private String LoanNo;
    /**
     *业务编号
     */
    private String businessNo;
}
