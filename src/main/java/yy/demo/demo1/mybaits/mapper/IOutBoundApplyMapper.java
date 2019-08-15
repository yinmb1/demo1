package yy.demo.demo1.mybaits.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import yy.demo.demo1.mybaits.entity.OutBoundApply;

import java.util.List;

/**
 * @author yinmb
 * @Date 2019/1/15 11:06:02
 */
@Mapper
@Component
public interface IOutBoundApplyMapper {

    OutBoundApply getbyapplySerialNo(Integer id);

    Integer updateOutBoundApply(OutBoundApply outBoundApply);

    Integer deleteOutBoundApply(Integer id);
}
