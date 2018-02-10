package cn.puhy.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnnotationSpel {

    //@Value从配置文件中加载值
    @Value("#{phyProperties['name']}")
    private String name;

    @Value("${age}")
    private String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
