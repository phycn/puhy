package phy.reflection.dynamicAgency;

public class GunDog implements Dog{

    @Override
    public void info() {
        System.out.println("猎狗！");
    }

    @Override
    public void run() {
        System.out.println("跑得快！");
    }
    
    
}
