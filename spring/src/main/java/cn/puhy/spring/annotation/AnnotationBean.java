package cn.puhy.spring.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//定义bean,可以被容器发现,与<bean id="annotationBean" class="cn.puhy.spring.annotation.AnnotationBean"/>等效
@Component("annotationBean")
//定义加载顺序，值越小，越优先被加载
@Order(value=1)
public class AnnotationBean extends Bean {

	@Override
	public String toString() {
		return "我是@Component注解的类";
	}
}
