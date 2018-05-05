package cn.puhy.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class CuratorCrud<T> {
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 5);//重试策略
    //工厂创建连接
    private CuratorFramework cf = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181,localhost:2182,localhost:2183")
            .sessionTimeoutMs(6000)
            .retryPolicy(retryPolicy)
            .build();
    //简单创建方式
    //CuratorFramework cf=CuratorFrameworkFactory.newClient(ZookeeperUtil.connectString,new RetryOneTime(1));

    public CuratorCrud() {
        //一定要启动
        cf.start();
    }

    /***
     * 建立节点 路径、数据内容
     * @param path
     * @param data
     */
    public void create(String path, byte[] data) {
        try {
            //creatingParentsIfNeeded 递归创建
            //withMode 创建模式
            cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 删除节点
     * deletingChildrenIfNeeded 是否删除子节点 递归
     * @param path
     */
    public void delete(String path) {
        try {
            cf.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 获取资源
     * @param path
     * @return
     */
    public byte[] getData(String path) {
        try {
            return cf.getData().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /***
     * 更新资源
     * @param path
     * @param bytes
     */
    public void setData(String path, byte bytes[]) {
        try {
            cf.setData().forPath(path, bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 节点是否存在
     * @param path
     */
    public Stat checkExists(String path) {
        try {
            return cf.checkExists().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /***
     * 获取子节点
     * @param path
     */
    public List<String> getChildren(String path) {
        try {
            return cf.getChildren().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 异步设置节点值
     *
     * @param path
     * @param data
     * @throws Exception
     */
    public void setDataAsync(String path, byte[] data) throws Exception {
        //监听
        CuratorListener listener = new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println(curatorEvent);
            }
        };
        cf.getCuratorListenable().addListener(listener);
        cf.setData().inBackground().forPath(path, data);
    }

    /**
     * 异步回调，就是设置完值后的操作
     *
     * @param path
     * @param data
     * @throws Exception
     */
    public void setDataAsyncWithCallback(String path, byte[] data) throws Exception {
        cf.setData().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("hehe");
            }
        }).forPath(path, data);
    }
}
