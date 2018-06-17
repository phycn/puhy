package cn.puhy.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * @author puhongyu
 * 2018/6/14 20:24
 */
public class FirstAgent {
    //先于main方法执行
    //-javaagent:/Users/puhongyu/phy/idea/javaagent/target/javaagent-1.0-SNAPSHOT.jar
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("agent start ...");
//        inst.addTransformer(new FirstEnhance());
        inst.addTransformer(new DispatcherServletEnhance());
        System.out.println("agent end ...");
    }
}
