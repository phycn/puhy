package test;

public class Invoker {
	
	@Autowired
	private Util util;
	
	public void test() {
		util.test();
	}
}
