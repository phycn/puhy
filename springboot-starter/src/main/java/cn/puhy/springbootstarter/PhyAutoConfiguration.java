package cn.puhy.springbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author puhongyu
 * 2018/8/22 23:47
 */
@Configuration  //开启配置
@EnableConfigurationProperties(PhyProperties.class)     //开启使用映射实体对象
@ConditionalOnClass(PhyService.class)                   //存在PhyService时初始化该配置类
@ConditionalOnProperty(prefix = "phy", value = "enabled", matchIfMissing = true)    ////存在对应配置信息时初始化该类
public class PhyAutoConfiguration {

    @Autowired
    private PhyProperties phyProperties;

    @Bean
    @ConditionalOnMissingBean(PhyService.class)         //缺失PhyService实体时初始化并加入Ioc容器
    public PhyService phyService() {
        System.out.println("init phyService...");
        PhyService phyService = new PhyService();
        phyService.sayHello(phyProperties.getName());
        phyService.setInfo("我是蒲红宇");
        return phyService;
    }
}
