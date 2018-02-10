//HashSet线程不安全
//不能保证元素的排列顺序

package phy.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    
    public static void main(String ... args) {
        HashSet hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-2));
        hs.add(new R(9));
        hs.add(new R(13));
        
        //取出第一个元素
        Iterator it = hs.iterator();
        R first = (R)it.next();
        System.out.println(first.count);
        //赋值
        first.count = 5;
        
        hs.remove(new R(5));
        System.out.println(hs);
        System.out.println(hs.contains(new R(5)));
    }
}

class R {
    
    int count;
    public R(int count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "count:" + count;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj != null && obj.getClass() == R.class) {
            R r = (R)obj;
            if(r.count == this.count) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.count;
    }
}
