package cn.puhy.spring.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
//延迟加载
@Lazy
public class AnnotationBean2 extends Bean {
	
	@Override
	public String toString() {
		return "我是@Service注解的类";
	}
}
