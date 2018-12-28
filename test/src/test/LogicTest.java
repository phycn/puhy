package test;

/**
 * @author PUHY
 * 2018-12-27 22:59
 */
public class LogicTest {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(1^2^3^3^4);
        System.out.println(1^2^3^4);
        System.out.println(7^3);
    }
}
