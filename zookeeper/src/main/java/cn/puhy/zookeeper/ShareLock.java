package cn.puhy.zookeeper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * 共享锁
 */
public class ShareLock implements Watcher {
    private ZooKeeper zk;
    private String root = "/lock";
    private String path;
    private String currentNode;
    private CountDownLatch latch;

    public ShareLock(String host, String path) {
        this.path = path;
        try {
            zk = new ZooKeeper(host, 5000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Stat sta = zk.exists(root, false);
            if (null == sta) {
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lock() {
        try {
            currentNode = zk.create(root + "/" + path, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(currentNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //获取所有子节点
            List<String> lockObjNodes = zk.getChildren(root, false);
            //排序
            Collections.sort(lockObjNodes);
            //创建的节点为第一个，表示获得了锁
            if (currentNode.equals(root + "/" + lockObjNodes.get(0))) {

            } else {
                //创建的节点名
                String childZnode = currentNode.substring(currentNode.lastIndexOf("/") + 1);
                //获取创建的节点在什么位置
                int num = Collections.binarySearch(lockObjNodes, childZnode);
                if (num == 0) {
                    num = 1;
                }
                //获取创建的节点前一个节点
                String waitNode = lockObjNodes.get(num - 1);
                //判断前一个节点是否存在，并监听，不存在直接获得锁
                Stat stat = zk.exists(root + "/" + waitNode, true);
                //前一个节点存在就等待
                if (null != stat) {
                    latch = new CountDownLatch(1);
                    this.latch.await(5000, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unLock() {
        try {
            zk.delete(currentNode, -1);
            currentNode = null;
            zk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        //这里与74行对应，latch不为空就countDown放行
        if (null != latch) {
            latch.countDown();
        }
    }
}
