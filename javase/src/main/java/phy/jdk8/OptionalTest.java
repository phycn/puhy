package phy.jdk8;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {

		Integer value1 = null;
		//ofNullable允许传递null
		Optional<Integer> a = Optional.ofNullable(value1);
		//of会报空指针异常
//		Optional<Integer> b = Optional.of(value1);
		//如果值存在则使用该值调用consumer(lambda表达式), 否则不做任何事情
		a.ifPresent(System.out::println);
		//如果存在该值，返回值，否则返回指定的值
		System.out.println(a.orElse(10));
		//存在即返回, 无则由函数来产生
		a.orElseGet(() -> Integer.valueOf(22));

		Bean bean = new Bean();
		Optional<String> fieldOp = Optional.ofNullable(bean.getField1());

		Optional<Bean> o = Optional.of(bean);
		String f1 = o.map(Bean::getField1).orElse("蒲红宇");
		System.out.println("" + f1);

		fieldOp.ifPresent((value) -> {
			System.out.println("ifPresent:" + value);
		});

		String field1 = fieldOp.orElseGet(() -> String.valueOf(12));
		System.out.println(field1);
	}
}

class Bean {

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	private String field1;
}
