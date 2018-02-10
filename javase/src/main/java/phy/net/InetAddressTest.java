package phy.net;

import java.net.InetAddress;

public class InetAddressTest{
    
    public static void main(String[] args) throws Exception {
        
        //根据主机名(域名)获取对应的InetAddress对象，也可以是字符串的IP地址
        InetAddress ip1 = InetAddress.getByName("192.168.1.42");
        //根据IP地址获取对应的InetAddress对象
        InetAddress ip2 = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("主机是否可达：" + ip1.isReachable(3000));
        //获取实例的IP字符串
        System.out.println(ip1.getHostAddress());
        //获取实例的全限定域名
        System.out.println(ip1.getCanonicalHostName());
    }
}
