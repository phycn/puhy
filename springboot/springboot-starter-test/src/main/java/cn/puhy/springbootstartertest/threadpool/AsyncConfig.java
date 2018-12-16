package cn.puhy.springbootstartertest.threadpool;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author PUHY
 * 2018-12-16 20:15
 */
@Component
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    //获取线程池
    @Override
    public Executor getAsyncExecutor() {
        System.out.println("获取线程池......");
        return Executors.newFixedThreadPool(10);
    }
}
