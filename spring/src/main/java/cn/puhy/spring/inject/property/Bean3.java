package cn.puhy.spring.inject.property;

public class Bean3 {
	
	private String field1;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	@Override
	public String toString() {
		return "Bean3 [field1=" + field1 + "]";
	}
}
