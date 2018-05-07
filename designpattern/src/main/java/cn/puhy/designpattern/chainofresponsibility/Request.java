package cn.puhy.designpattern.chainofresponsibility;

/**
 * @author puhongyu
 * 2018/5/5 21:40
 */
public class Request {
    //请求的等级
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
