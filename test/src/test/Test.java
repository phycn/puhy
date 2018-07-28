package test;

public class Test {

    static int a;

    static {
        a = 22;
        System.out.println("1111");
    }

    public static void aa() {
        System.out.println("222");
    }
    
    public static void main(String[] args) throws Exception {
        aa();
        aa();
        aa();
    }
}


