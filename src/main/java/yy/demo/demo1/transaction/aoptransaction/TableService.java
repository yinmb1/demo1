package yy.demo.demo1.transaction.aoptransaction;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yy.demo.demo1.common.dao.TestTableMapper;
import yy.demo.demo1.common.entity.TestTable;

/**
 * @author yinmb
 * @Date 2019/5/27 17:09:36
 */
@Slf4j
@Service
public class TableService {
    @Autowired
    private TestTableMapper testTableMapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void updateScore(String username,String lastname,int scoreDo){
        testTableMapper.updateTestTable(username,scoreHandle(username)-scoreDo);

        testTableMapper.updateTestTable(lastname,scoreHandle(lastname)+scoreDo);
       // int i=100/0;
    }

    public Integer scoreHandle(String name){
        TestTable testTable = testTableMapper.getbyName(name);
        log.info(JSON.toJSONString(testTable));
        return testTable.getScore();
    }
}
