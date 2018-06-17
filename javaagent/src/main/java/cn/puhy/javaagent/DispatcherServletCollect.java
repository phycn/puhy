package cn.puhy.javaagent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puhongyu
 * 2018/6/15 06:54
 */
public class DispatcherServletCollect {
    public static void begin(Object params[]) {
        System.out.println("111222333");
        HttpServletRequest request = (HttpServletRequest) params[0];
        System.out.println("远程地址是：" + request.getRequestURI());
    }
}
