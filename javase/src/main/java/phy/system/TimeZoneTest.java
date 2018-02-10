package phy.system;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneTest {
    
    public static void main(String[] args) {
        
        //获取所支持的所有时区ID
        String[] ids = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(ids));
        //获取默认的时区
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());
        //获取默认时区的名称
        System.out.println(tz.getDisplayName());
        //获取指定时区的名称
        System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
    }
}
