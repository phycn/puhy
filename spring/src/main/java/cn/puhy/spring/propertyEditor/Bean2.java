package cn.puhy.spring.propertyEditor;

public class Bean2 {
	
	private String str1;
	private Bean1 bean1;
	
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public Bean1 getBean1() {
		return bean1;
	}
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}
	@Override
	public String toString() {
		return "Bean2 [str1=" + str1 + ", bean1=" + bean1 + "]";
	}
}
