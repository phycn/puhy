package cn.puhy.springbootstarter;

/**
 * @author puhongyu
 * 2018/8/22 23:48
 */
public class PhyService {

    private String info;

    public void sayHello(String name) {
        System.out.println("你好呀，" + name);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
