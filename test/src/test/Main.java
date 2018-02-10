package test;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Invoker i = new Invoker();
		AutowiredManager.analysis(i);
		
		i.test();
	}
}
