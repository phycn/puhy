package cn.puhy.spring.ioc.lifecycle;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * 实现容器级生命周期接口，也称为后处理器
 * @author puhongyu
 *
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
	
	//对bean进行加工
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("11-调用InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization");
		return super.postProcessAfterInitialization(bean, beanName);
	}

	//对bean进行加工
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("8-调用InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInitialization");
		return super.postProcessBeforeInitialization(bean, beanName);
	}

	//在设置某个属性时调用
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		
		if("car".equals(beanName)) {
			System.out.println("4-bean设置属性时调用");
		}
		return pvs;
	}

	//在实例化bean后调用
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		
		if("car".equals(beanName)) {
			System.out.println("3-实例化bean后调用");
		}
		return true;
	}

	//在实例化bean前调用
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		
		if("car".equals(beanName)) {
			System.out.println("1-实例化bean前调用");
		}
		return null;
	}
}
