package test;

import java.lang.reflect.Field;

public class AutowiredManager {
	
	public static void analysis(Object target) throws InstantiationException, IllegalAccessException {
		Field[] fields = target.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(Autowired.class)) {
				field.setAccessible(true);
				Object o = field.getType().newInstance();
				field.set(target, o);
			}
		}
	}
}
