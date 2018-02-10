package phy.reflection.dynamicAgency;

public class Test {
    
    public static void main(String[] args) throws Exception {
        
        //创建一个原始的GunDog对象作为target
        Dog target = new GunDog();
        //以指定的target来创建动态代理对象
        Dog dog = (Dog)MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
