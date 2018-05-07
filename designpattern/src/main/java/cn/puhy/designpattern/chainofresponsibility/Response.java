package cn.puhy.designpattern.chainofresponsibility;

/**
 * @author puhongyu
 * 2018/5/5 21:38
 */
public class Response {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    //处理者返回的数据
    private String data;
}
