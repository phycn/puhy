package cn.puhy.zookeeper.curator;

/**
 * @author puhongyu
 * 2018/5/1 09:38
 */
public class CuratorCrudTest {
    public static void main(String[] args) throws Exception {
        CuratorCrud c = new CuratorCrud();
//        c.setDataAsync("/curator", "phy".getBytes());
//        c.setDataAsyncWithCallback("/curator", "phy".getBytes());
        c.create("/curator", "11".getBytes());
//        while (true) {
//
//        }
    }
}
