package cn.puhy.springbootfirst;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * Bean1对象存在才进行加载
 *
 * @author puhongyu
 * 2018/5/24 21:09
 */

@Component
@ConditionalOnBean(name = {"bean1"})
public class BeanConditional {

}
