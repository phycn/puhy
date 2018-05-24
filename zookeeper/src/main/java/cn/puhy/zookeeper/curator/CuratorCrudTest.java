package cn.puhy.zookeeper.curator;

import java.util.Collections;
import java.util.List;

/**
 * @author puhongyu
 * 2018/5/1 09:38
 */
public class CuratorCrudTest {
    public static void main(String[] args) throws Exception {
        CuratorCrud c = new CuratorCrud();
//        c.setDataAsync("/curator", "phy".getBytes());
//        c.setDataAsyncWithCallback("/curator", "phy".getBytes());
//        c.create("/curator", "11".getBytes());
        c.createEphemeral("/phy/linshi", "".getBytes());

        List<String> list = c.getChildren("/phy");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
