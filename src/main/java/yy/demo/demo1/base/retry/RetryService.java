package yy.demo.demo1.base.retry;

/**
 * @author yinmb
 * @Date 2019/5/23 09:30:25
 */

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import yy.demo.demo1.exception.utils.RestUtils;

@Service
public class RetryService {

    @Retryable(value= {RemoteAccessException.class},maxAttempts = 3,backoff = @Backoff(delay = 5000L,multiplier = 1))
    public void call() throws Exception {
        System.out.println("do something...");
        throw new RemoteAccessException("RPC调用异常");
    }
    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("1233143212");
    }
}