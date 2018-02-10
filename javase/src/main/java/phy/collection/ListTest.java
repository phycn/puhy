package phy.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    
    public static void main(String ... args) {
        
        List phy = new ArrayList();
        phy.add(1);
        phy.add(2);
        phy.add(3);
        System.out.println(phy);
        //插在索引为1的位置
        phy.add(1, 9);
        //设置索引为1的值
        phy.set(1, 5);
        System.out.println(phy);
        
        //返回索引1到3（不包括）的值
        phy.subList(1, 3);
        System.out.println(phy);
    }
}
