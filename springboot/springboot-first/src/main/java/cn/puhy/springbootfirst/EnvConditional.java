package cn.puhy.springbootfirst;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author puhongyu
 * 2018/5/24 21:24
 */
@Component
//有属性名为myName，属性值为puhongyu的env属性才进行加载，matchIfMissing为false表示没有这属性不会进行加载
@ConditionalOnProperty(name = "myName", havingValue = "puhongyu", matchIfMissing = false)
public class EnvConditional {
}
