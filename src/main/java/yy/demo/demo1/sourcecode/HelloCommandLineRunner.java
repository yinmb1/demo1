package yy.demo.demo1.sourcecode;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author yinmb
 * @Date 2019/3/15 18:59:37
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("HelloCommandLineRunner......Start..."+ JSON.toJSONString(strings));
    }
}
