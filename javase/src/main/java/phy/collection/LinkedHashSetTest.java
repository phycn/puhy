/*
 * LinkedHashSet是按插入顺序排列元素的
 */
package phy.collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    
    public static void main(String ... args) {
        
        LinkedHashSet phy = new LinkedHashSet();
        phy.add("萨比");
        phy.add("瓜娃子");
        System.out.println(phy);
        
        phy.remove("萨比");
        phy.add("萨比");
        System.out.println(phy);
    }
}
