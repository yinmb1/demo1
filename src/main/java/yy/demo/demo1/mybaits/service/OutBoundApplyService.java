package yy.demo.demo1.mybaits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yy.demo.demo1.mybaits.entity.OutBoundApply;
import yy.demo.demo1.mybaits.mapper.IOutBoundApplyMapper;

import java.util.List;

/**
 * @author yinmb
 * @Date 2019/1/15 11:10:00
 */
@Service
public class OutBoundApplyService  {
    @Autowired
    private IOutBoundApplyMapper outBoundApplyMapper;


    @Cacheable(cacheNames = "users",key = "#id")
    public OutBoundApply getbyapplySerialNo(Integer id) {
        return outBoundApplyMapper.getbyapplySerialNo(id);
    }

    @CachePut(cacheNames = "users",key = "#outBoundApply.id")
    public OutBoundApply updateOutBoundApply(OutBoundApply outBoundApply){
        outBoundApplyMapper.updateOutBoundApply(outBoundApply);
        return outBoundApplyMapper.getbyapplySerialNo(outBoundApply.getId());
    }

    @CacheEvict(cacheNames = "users" ,key = "#id")
    public Integer deleteOutBoundApply(Integer id){
        return outBoundApplyMapper.deleteOutBoundApply(id);
    }
}
