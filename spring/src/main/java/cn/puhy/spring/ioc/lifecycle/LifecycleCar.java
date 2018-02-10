package cn.puhy.spring.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现各种bean级生命周期接口的bean
 * @author puhongyu
 *
 */
public class LifecycleCar implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	
	private String brand;
	private String color;
	private String maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	public LifecycleCar() {
		System.out.println("2-调用构造函数");
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("5-调用setBrand设置属性");
	}

	//BeanFactoryAware接口方法
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("7-调用BeanFactoryAware.setBeanFactory");
		this.beanFactory = beanFactory;
	}

	//BeanNameAware接口方法
	@Override
	public void setBeanName(String str) {
		System.out.println("6-调用BeanNameAware.setBeanName");
		this.beanName = str;
	}

	//InitializingBean接口方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("9-调用InitializingBean.afterPropertiesSet");
	}

	//DisposableBean接口方法
	@Override
	public void destroy() throws Exception {
		System.out.println("12-调用DisposableBean.destroy");
	}
	
	//通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("10-调用init-method所指定的myInit");
		this.maxSpeed = "240";
	}
	
	//通过<bean>的destroy-method属性指定的销毁方法
	public void myDestroy() {
		System.out.println("13-调用destroy-method所指定的myDestroy");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + ", beanFactory=" + beanFactory
				+ ", beanName=" + beanName + "]";
	}
}
