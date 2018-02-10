package cn.puhy.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<MyBean> {
	
	private String myBeanInfo;

	public String getMyBeanInfo() {
		return myBeanInfo;
	}

	public void setMyBeanInfo(String myBeanInfo) {
		this.myBeanInfo = myBeanInfo;
	}

	//实例化bean
	@Override
	public MyBean getObject() throws Exception {
		
		MyBean myBean = new MyBean();
		String[] infos = myBeanInfo.split(",");
		myBean.setField1(infos[0]);
		myBean.setField2(infos[1]);
		myBean.setField3(infos[2]);
		
		return myBean;
	}

	@Override
	public Class<?> getObjectType() {
		return MyBean.class;
	}

	//是否是单例
	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public String toString() {
		return "这是我的测试，看看有没有生成";
	}
}
