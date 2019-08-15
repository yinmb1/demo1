package yy.demo.demo1.spring.applicationcontext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yy.demo.demo1.spring.applicationcontext.ApplicationContextHolder;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象食物类
 * @author yinmb
 * @Date 2019/6/20 14:55:56
 */

public abstract class AbstractFoodService {
    /**
     * 初始化逻辑
     */
    @PostConstruct
    public abstract void init();
    /**
     * 子类service的映射
     */
    private static Map<String, Class<? extends AbstractFoodService>> typeServiceMap = new ConcurrentHashMap<String, Class<? extends AbstractFoodService>>();


    /**
     * 添加子类服务
     * @param key
     * @param service
     */
    protected  void addServiceByTypeInMap(String key, Class<? extends AbstractFoodService> service) {
        typeServiceMap.put(key, service);
    }

    /**
     * 获取类型
     * @return
     */
    public abstract String  getType();

    /**
     * 添加子类服务
     * @param key
     */
    public  AbstractFoodService getServiceByTypeInMap(String key) {


        Class<? extends AbstractFoodService> clazz = typeServiceMap.get(key);
        AbstractFoodService service = ApplicationContextHolder.getBean(clazz);
        return service;
    }

    public void getName(){}

}
