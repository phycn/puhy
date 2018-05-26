package cn.puhy.springbootfirst;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * 指定的类在Classpath中才进行加载
 * @author puhongyu
 * 2018/5/24 21:18
 */
@Component
@ConditionalOnClass(Bean1.class)
public class ClassConditional {
}
