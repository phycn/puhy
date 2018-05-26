package cn.puhy.springbootfirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author puhongyu
 * 2018/5/24 20:39
 */
@Configuration
public class EnvConfig {
    @Autowired
    private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
