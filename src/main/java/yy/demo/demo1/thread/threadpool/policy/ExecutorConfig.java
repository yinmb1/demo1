package yy.demo.demo1.thread.threadpool.policy;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/18 2:57 下午
 */

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * laizhenwei 2018-1-1 12:46:02
 */
@Configuration
@EnableAsync
public class ExecutorConfig implements AsyncConfigurer {

	/**
	 * 替换默认线程池,线程队列满了以后交给调用者执行,也就是同步执行
	 * @return
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(7);
		executor.setMaxPoolSize(42);
		executor.setQueueCapacity(11);
		executor.setThreadNamePrefix("Executor-");
		executor.setAllowCoreThreadTimeOut(false);
		executor.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

	/**
	 * 队列满了以后,抛弃任务,但是会抛出 rejectedExecution 如果不处理会中断线程
	 * @return
	 */
	@Bean
	public Executor myExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(20);
		executor.setThreadNamePrefix("MyExecutor-");
		executor.setAllowCoreThreadTimeOut(false);
		executor.setRejectedExecutionHandler( new ThreadPoolExecutor.AbortPolicy());
		executor.initialize();
		return executor;
	}

	/**
	 * 队列满了,直接丢弃当前任务,不抛出异常
	 * @return
	 */
	@Bean
	public Executor myExecutor1() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(20);
		executor.setThreadNamePrefix("MyExecutor1-");
		executor.setAllowCoreThreadTimeOut(false);
		executor.setRejectedExecutionHandler( new ThreadPoolExecutor.DiscardPolicy());
		executor.initialize();
		return executor;
	}

	/**
	 * 队列满了,丢弃最老的任务,不抛出异常
	 * @return
	 */
	@Bean
	public Executor myExecutor2() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(20);
		executor.setThreadNamePrefix("MyExecutor2-");
		executor.setAllowCoreThreadTimeOut(false);
		executor.setRejectedExecutionHandler( new ThreadPoolExecutor.DiscardOldestPolicy());
		executor.initialize();
		return executor;
	}



}
