package cn.puhy.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBean3 extends Bean {
	
	//@Autowired自动注入bean，required为false表示没找到对应bean也不会报错
	@Autowired(required=false)
	//@Qualifier指定注入bean的名称
	@Qualifier("annotationBean")
	private AnnotationBean annotationBean;
	
	private AnnotationBean2 annotationBean2;
	
	//自动将bean注入方法参数
	@Autowired
	public void setAnnotationBean2(AnnotationBean2 annotationBean2) {
		this.annotationBean2 = annotationBean2;
	}

	@Override
	public String toString() {
		return "我是AnnotationBean3,注入的是：[" + annotationBean.toString() + "]，[" + annotationBean2.toString() + "]";
	}
}
