package cn.puhy.zookeeper.curator;

/**
 * @author puhongyu
 * 2018/5/1 10:34
 */
public class CuratorWatcherTest {
    public static void main(String[] args) throws Exception {
        CuratorWatcher cw = new CuratorWatcher();
        //只能监听一次
//        cw.setListenter1("/curator");
//        cw.setListenter2("/curator");
        //监听子节点，可以无限监听
//        cw.setListenter3("/curator");
        //监听指定节点
        cw.setListenter4("/curator");
        //监听节点和它的子节点
        cw.setListenter5("/curator");
        while (true) {

        }
    }
}
