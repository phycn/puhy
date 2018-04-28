package cn.puhy.designpattern.proxy;

/**
 * @author puhongyu
 * 2018/4/21 18:17
 */
public class Client {
    public static void main(String[] args) {
        Subject real = new RealSubject();
        //代理具体的
        Subject proxy = new Proxy(real);
        proxy.request();
    }
}
