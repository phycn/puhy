package cn.puhy.spring.annotation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBean4 {
	
	//将所有类型为Bean的bean注入到List中
	@Autowired
	private List<Bean> beanList;
	
	//将所有类型为Bean的bean注入到Map中
	@Autowired
	private Map<String, Bean> beanMap;
	
	public void getListAndMap() {
		for(Bean bean : beanList) {
			System.out.println(bean);
		}
	}
}
