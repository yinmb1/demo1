package yy.demo.demo1.http;

import java.util.concurrent.*;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/15 10:13 下午
 */
public class ThreadPools {
	public static ExecutorService exec = new ThreadPoolExecutor(
			100,
			300,
			0L,
			TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>(1024),
			new ThreadFactory() {
				@Override
				public Thread newThread(Runnable r) {
					return new Thread(r);
				}
			},
			new ThreadPoolExecutor.AbortPolicy());
}


