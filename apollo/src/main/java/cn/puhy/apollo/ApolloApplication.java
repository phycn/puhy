package cn.puhy.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig({"application", "TEST1.public"})     //开启apollo配置，获取application和TEST1.public namespace的配置
public class ApolloApplication {

    @ApolloConfig   //自动注入Config对象
    private Config config;

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class, args);
    }

    @ApolloConfigChangeListener({"application", "TEST1.public"})     //自动注册ConfigChangeListener，监听配置变化
    private void someOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged("phy")) {
            System.out.println(config.getProperty("phy", "hehe"));
        }
    }
}

