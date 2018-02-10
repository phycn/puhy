package phy.generic;

//定义A1继承Apple类时不能用类型形参，可以什么都不用
//public class A1 extends Apple<T>
public class A1 extends Apple<String> {
	// 正确重写了父类的方法，返回值
	// 与父类Apple<String>的返回值完全相同
	@Override
    public String getInfo() {
		return "子类" + super.getInfo();
	}
	/*
	 * // 下面方法是错误的，重写父类方法时返回值类型不一致 public Object getInfo() { return "子类"; }
	 */
}

class A2 extends Apple {
	// 重写父类的方法
	@Override
    public String getInfo() {
		// super.getInfo()方法返回值是Object类型，
		// 所以加toString()才返回String类型
		return super.getInfo().toString();
	}
}
