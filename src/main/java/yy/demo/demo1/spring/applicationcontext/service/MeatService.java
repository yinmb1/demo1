package yy.demo.demo1.spring.applicationcontext.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author yinmb
 * @Date 2019/6/20 18:27:53
 */
@Service
public class MeatService extends AbstractFoodService {
    private  String foodType = "Meat";

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
