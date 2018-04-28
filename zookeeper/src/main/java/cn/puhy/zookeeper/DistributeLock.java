package cn.puhy.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 分布式独占锁
 *
 * @author puhongyu
 * 2018/4/28 21:43
 */
public class DistributeLock {

    private ZooKeeper zooKeeper;
    private String path;

    public DistributeLock(String host, String path) {
        try {
            this.zooKeeper = new ZooKeeper(host, 6000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.path = path;
    }

    /***
     * 创建一个临时的节点
     */
    public void lock() {
        try {
            zooKeeper.create(path, path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (Exception e) {
            try {
                CountDownLatch latch = new CountDownLatch(1);
                latch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            lock();

        }

    }

    public void unlock() {
        try {
            //删除这个节点
            zooKeeper.delete(path, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
