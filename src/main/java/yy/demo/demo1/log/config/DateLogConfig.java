package yy.demo.demo1.log.config;

import ch.qos.logback.core.PropertyDefinerBase;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日志获取时间
 * @author yinmb
 * @Date 2019/7/16 15:36:30
 */
public class DateLogConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {

        return getLocalHostName();
    }

    /**
     * 获取本机日期
     *
     * @return
     */
    private String getLocalHostName() {
        return new SimpleDateFormat ("YYYY-MM-DD").format(new Date());
    }



}
