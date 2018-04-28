package cn.puhy.designpattern.prototype;

/**
 * @author puhongyu
 * 2018/4/23 20:55
 */
public class PrototypeClass implements Cloneable {
    @Override
    protected PrototypeClass clone() throws CloneNotSupportedException {
        return (PrototypeClass) super.clone();
    }

    public void doSometing() {
        System.out.println("hehe");
    }
}
