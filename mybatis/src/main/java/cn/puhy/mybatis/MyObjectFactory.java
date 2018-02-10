package cn.puhy.mybatis;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class MyObjectFactory extends DefaultObjectFactory {
	
	private static final long serialVersionUID = 4206670740598985819L;

	@Override
    public <T> T create(Class<T> type) {
//		System.out.println("创建：" + type.getName());
		return super.create(type);
	}

	@Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		System.out.println(type.getName());
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
    public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	@Override
    public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}
