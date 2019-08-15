package yy.demo.demo1.sourcecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author yinmb
 * @Date 2019/3/15 13:50:19
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;
    private final String[] args;
    private final SimpleApplicationEventMulticaster initialMulticaster;
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
        this.initialMulticaster = new SimpleApplicationEventMulticaster();
        Iterator var3 = application.getListeners().iterator();

        while(var3.hasNext()) {
            ApplicationListener<?> listener = (ApplicationListener)var3.next();
            this.initialMulticaster.addApplicationListener(listener);
        }

    }

    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener...starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
        System.out.println("HelloSpringApplicationRunListener...environmentPrepared..."+configurableEnvironment.toString());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener...contextPrepared..."+configurableApplicationContext.toString());
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener...contextLoaded..."+configurableApplicationContext.toString());

    }

    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
      //  System.out.println("HelloSpringApplicationRunListener...finished..."+configurableApplicationContext.toString());

    }
}
