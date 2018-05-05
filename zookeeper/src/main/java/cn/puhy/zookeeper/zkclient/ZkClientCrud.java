package cn.puhy.zookeeper.zkclient;


import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.util.List;

public class ZkClientCrud<T> {

    private ZkClient zkClient;

    public ZkClientCrud(ZkSerializer zkSerializer) {
        System.out.println("connect zk");
        zkClient = new ZkClient("localhost:2181,localhost:2182,localhost:2183", 6000, 6000, zkSerializer);
    }

    /**
     * 创建临时节点
     *
     * @param path
     * @param data
     */
    public void createEphemeral(String path, Object data) {
        zkClient.createEphemeral(path, data);
    }

    /***
     * 支持创建递归方式
     * @param path
     * @param createParents
     */
    public void createPersistent(String path, boolean createParents) {
        zkClient.createPersistent(path, createParents);
    }

    /***
     * 创建节点 跟上data数据
     * @param path
     * @param data
     */
    public void createPersistent(String path, Object data) {
        zkClient.createPersistent(path, data);
    }

    /***
     * 子节点
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        return zkClient.getChildren(path);

    }

    public T readData(String path) {
        return zkClient.readData(path);
    }

    public void writeData(String path, Object data) {
        zkClient.writeData(path, data);
    }

    public void deleteRecursive(String path) {
        zkClient.deleteRecursive(path);
    }
}
