package phy.jmx.Notifications;

import javax.management.*;

public class Hello
        extends NotificationBroadcasterSupport implements HelloMBean {

    @Override
    public void sayHello() {
        System.out.println("hello, world");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCacheSize() {
        return this.cacheSize;
    }

    @Override
    public synchronized void setCacheSize(int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;

        System.out.println("Cache size now " + this.cacheSize);

        Notification n
                = new AttributeChangeNotification(this,       //通知生成者，也就是该属性所属的 MBean
                        sequenceNumber++,                     //源对象内的通知序列号
                        System.currentTimeMillis(),           //发送通知的日期
                        "啦啦啦",                  //包含通知消息的 String
                        "cacheSize",                          //被修改属性名
                        "int",                                //被修改属性类型
                        oldSize,                              //被修改属性修改以前的值
                        this.cacheSize);                      //被修改属性修改以后的值

        sendNotification(n);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
            AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info
                = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int DEFAULT_CACHE_SIZE = 233;

    private long sequenceNumber = 1;
}
