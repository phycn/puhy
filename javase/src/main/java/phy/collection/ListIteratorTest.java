package phy.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    
    public static void main(String ... args) {
        
        List phy = new ArrayList();
        phy.add(1);
        phy.add(2);
        phy.add(4);
        phy.add(5);
        phy.add(9);
        
        ListIterator li = phy.listIterator();
        while(li.hasNext()) {
            //ListIterator可以向List中添加元素
            System.out.println(li.next());
            li.add(666);
        }
        //反向迭代
        while(li.hasPrevious()) {
            
            System.out.println(li.previous());
        }
    }
}
