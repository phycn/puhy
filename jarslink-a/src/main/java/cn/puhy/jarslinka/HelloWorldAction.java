package cn.puhy.jarslinka;

import com.alipay.jarslink.api.Action;

/**
 * @author puhongyu
 * 2018/5/3 19:43
 */
public class HelloWorldAction implements Action<String, String> {
    //Action的泛型第一个为方法的入参类型，第二个为方法的返回类型
    public String execute(String str) {
        return "hello 2.0version " + str;
    }

    public String getActionName() {
        return "helloWorld";
    }
}
