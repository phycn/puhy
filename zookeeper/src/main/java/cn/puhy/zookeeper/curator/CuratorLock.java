package cn.puhy.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLock {

    private InterProcessMutex lock;

    public CuratorLock(String path) {
        //工厂创建连接
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 5);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181,localhost:2182,localhost:2183")
                .sessionTimeoutMs(6000)
                .retryPolicy(retryPolicy)
                .build();
        lock = new InterProcessMutex(cf, path);
        cf.start();//链接
    }

    /***
     * 获取资源
     * @see org.apache.curator.framework.recipes.locks.LockInternals
     * @throws Exception
     */
    public void acquire() throws Exception {
        lock.acquire();
    }

    /****
     * 释放资源
     * @throws Exception
     */
    public void release() throws Exception {
        lock.release();
    }
}
