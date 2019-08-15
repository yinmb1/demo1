package yy.demo.demo1.common.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import yy.demo.demo1.common.entity.TestTable;

/**
 * @author yinmb
 * @Date 2019/5/27 16:49:43
 */
@Component
public interface TestTableMapper {

    TestTable getbyName(String name);

    Integer updateTestTable(@Param("name")String name, @Param("score")int score);

}
