package cn.puhy.zookeeper.zkclient;

/**
 * @author puhongyu
 * 2018/4/30 17:50
 */
public class Test {
    public static void main(String[] args) {
        ZkClientWatcher zkClientWatche = new ZkClientWatcher();
        zkClientWatche.createPersistent("/phy/hehe", "word");
    }
}
