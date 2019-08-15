package yy.demo.demo1.spring.applicationcontext.service;


import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 苹果味面包
 * @author yinmb
 * @Date 2019/6/20 15:48:
 *
 */

@Service
public class AppleBreadService extends BreadService {
    private  String foodType = "AppleBread";

    @Override
    public String getType() {
        return foodType;
    }

    /**
     * 初始化逻辑
     */
    @Override
    @PostConstruct
    public void init(){
        super.addServiceByTypeInMap(foodType,getClass());
    }

    @Override
    public void getName(){
        System.out.println(foodType +" 服务被调到");
    }
}
