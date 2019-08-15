package yy.demo.demo1.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;




/**
 * @author yinmb
 * @Date 2019/3/27 10:21:16
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**自动注入spring boot默认的上传配置*/
    @Autowired
    private MultipartConfigElement multipartConfigElement;

    @Autowired
    private DispatcherServlet dispatcherServlet;
    /**
     * 配置接收/http/的请求
     * @author yinmb
     * @date 2018/5/9 14:58
     * @since
     * @param
     */
    @Bean
    public ServletRegistrationBean apiServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
        //注入上传配置到自己注册的ServletRegistrationBean
        bean.addUrlMappings("/http/*");
        bean.setMultipartConfig(multipartConfigElement);
        bean.setName("httpServlet");
        System.out.println("配置接收/http/的请求");
        return bean;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
