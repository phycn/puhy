package phy.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
    
    public static void main(String[] args) {
        
        Collection c = new HashSet();
        c.add("p");
        c.add("h");
        c.add("y");
        //获取集合对应的迭代器
        Iterator it = c.iterator();
        //集合元素还没有被遍历，则返回true
        while(it.hasNext()) {
            //返回类型为Object，需要强制类型转换
            String a = (String) it.next();
            if(a.equals("h")) {
                //只能通过Iterator的remove删除
               it.remove();
               //会报错
               //c.remove(a);
            }
        }
        System.out.println(c);
    }
}
