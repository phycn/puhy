package phy.system;

import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.DATE;

public class CalendarTest {
    
    public static void main(String[] args) {
        
        //Calendar类是抽象类，不能使用构造器来创建
        Calendar c = Calendar.getInstance();
        c.roll(DATE, -2779);
        System.out.println("%%%%%%%%" + c.getTime());
        
        //取出年份
        System.out.println(c.get(YEAR));
        //取出月份，从0开始
        System.out.println(c.get(MONTH));
        //分别设置年、月、日、小时、分、秒
        c.set(2014, 5, 25, 01, 01, 01);
        //获取Date对象
        System.out.println(c.getTime());
        //向后推8个月
        //add方法修改的字段超出最大范围后，会发生进位，即上一级也会增大
        c.add(MONTH, 8);
        System.out.println(c.getTime());
        //roll方法修改的字段超出最大范围后，不会发生进位
        c.roll(MONTH, 8);
        System.out.println("%%%%%%%%" + c.getTime());
        
        //关闭容错性
        c.setLenient(true);
        //会报错，最大只能是11
        c.set(MONTH, 13);
        System.out.println(c.getTime());
        
    }
}
