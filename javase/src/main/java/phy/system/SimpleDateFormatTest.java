package phy.system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    
    public static void main(String[] args) {
        
        Date d = new Date();
        // DDD代表年中的天数
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b = s.format(d);
        System.out.println(b);
    }
}
