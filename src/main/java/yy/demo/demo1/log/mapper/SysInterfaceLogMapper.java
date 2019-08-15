package yy.demo.demo1.log.mapper;

import org.springframework.stereotype.Component;
import yy.demo.demo1.log.SysInterfaceLog;

/**
 * 接口日志Mapper
 * @author yinmb
 * @date 2018/01/11
 */
@Component
public interface SysInterfaceLogMapper {

    int insert(SysInterfaceLog sysInterfaceLog);
}
