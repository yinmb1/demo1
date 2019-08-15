package yy.demo.demo1.aop.currentProxy;

import org.springframework.stereotype.Service;

/**
 * @author yinmb
 * @Date 2019/4/8 17:07:29
 */
@Service
public class GreetingServiceImpl {

    public void sayMessage(String message) {
        System.out.println("GreetingService.sayMessage " + message);
        this.sayHello();//调用同个service下的方法
    }


    public void sayHello() {
        System.out.println("GreetingService.sayHello()");
    }


}
