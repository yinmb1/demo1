package yy.demo.demo1.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author yinmb
 * @Date 2019/6/20 14:54:13
 */
@Service
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取spring的bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * 获取spring的beans
     */
    public static <T> Collection<T> getBeans(Class<T> requiredType) {
        return applicationContext.getBeansOfType(requiredType).values();
    }

    /**
     * 获取spring的bean
     */
    public static <T> T getBean(String beanName, Class<T> requiredType) {
        return applicationContext.getBean(beanName, requiredType);
    }

    /**
     * 获取spring的bean
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
