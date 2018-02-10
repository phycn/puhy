package phy.system;

import java.util.Objects;

public class ObjectsTest {
    
    public static void main(String[] args) {
    
        String a = null;
        //输出hashCode值，为null输出0
        System.out.println(Objects.hashCode(a));
        //为null输出null
        System.out.println(Objects.toString(a));
        //要求不能为null,如果为null则引发异常
        System.out.println(Objects.requireNonNull(a, "不能为null"));
    }
}
