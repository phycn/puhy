package cn.puhy.springbootstartertest.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author PUHY
 * 2018-12-16 20:18
 */
@Service
public class AsyncService {

    @Async
    public void longTimeMethod() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("执行完啦");
    }
}
