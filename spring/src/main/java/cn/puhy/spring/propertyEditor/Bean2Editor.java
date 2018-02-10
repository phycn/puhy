package cn.puhy.spring.propertyEditor;

import java.beans.PropertyEditorSupport;

public class Bean2Editor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		//将字面值转换为属性类型对象
		String[] infos = text.split(",");
		Bean1 bean1 = new Bean1();
		bean1.setField1(infos[0]);
		bean1.setField2(infos[1]);
		
		//调用父类方法设置转换后的属性对象
		super.setValue(bean1);
	}
}
