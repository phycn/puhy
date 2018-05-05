package cn.puhy.jarslink;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author puhongyu
 * 2018/5/3 19:52
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/config.xml");
        //ModuleManager负责注册，卸载，查找模块和执行Action
        ModuleManager manager = (ModuleManager) ctx.getBean("moduleManager");
        //ModuleLoader只负责加载模块
        ModuleLoader loader = (ModuleLoader) ctx.getBean("moduleLoader");
        Module module = manager.find("jarslink-a");
        for (int i = 0; i < 1000; i++) {
            if(i == 10) {
                ModuleConfig newModuleConfig = ModuleRefreshSchedulerImpl.buildAModuleConfig("jarslink-a-2.0.jar", "jarslink-a", "2.0");
                Module newModule = loader.load(newModuleConfig);
                manager.register(newModule);
                module = manager.find("jarslink-a");
            }

            String str = module.doAction("helloWorld", "phy");
            System.out.println(str);
            Thread.sleep(2000);
        }
    }
}
