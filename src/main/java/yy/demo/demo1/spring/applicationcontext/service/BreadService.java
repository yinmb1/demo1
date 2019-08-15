package yy.demo.demo1.spring.applicationcontext.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 面包
 * @author yinmb
 * @Date 2019/6/20 15:01:18
 */
@Primary
@Service
public class BreadService extends AbstractFoodService {
    private  String foodType = "Bread";

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
