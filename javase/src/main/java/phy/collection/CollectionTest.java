package phy.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    
    public static void main(String[] args) {
        
        Collection c = new ArrayList();
        //添加元素
        c.add("phy");
        c.add(6);
        //删除元素
        c.remove(6);
        //判断是否包括指定元素
        System.out.println(c.contains(6));
        //清除所有元素
        c.clear();
        //不包含元素则返回true
        System.out.println(c.isEmpty());
        
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        //将c1的所有元素添加到c中
        c.addAll(c1);
        //c是否包含c1的所有元素
        c.containsAll(c1);
        //删除c集合中的c1集合的元素
        c.removeAll(c1);
    }
}
