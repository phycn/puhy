package cn.puhy.spring.inject.constructor;

public class Bean2 {
	
	private String field1;
	private String field2;
	
	public Bean2(String field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}
}
