package yy.demo.demo1.log;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yy.demo.demo1.log.mapper.SysInterfaceLogMapper;

/**
 * 接口日志Service
 * @author yinmb
 * @date 2018/01/11
 */
@Service
public class SysInterfaceLogService {

    @Autowired
    private SysInterfaceLogMapper sysInterfaceLogMapper;

    public int insert(SysInterfaceLog sysInterfaceLog){
       return  sysInterfaceLogMapper.insert(sysInterfaceLog);
    }
}
