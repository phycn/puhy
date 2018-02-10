package phy.oop;

public class VariableParameter {
	private static void test(String ... str) {
		for(String s : str) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		test("1","2","3");
	}
}
