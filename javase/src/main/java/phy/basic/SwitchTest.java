/*
 * java 7允许switch语句的控制表达式为String类型，java7以前只能是char，short，int
 */
package phy.basic;

public class SwitchTest {

    public static void main(String... args) {

        String a = "A";

        switch (a) {

            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            //前面都不符合的情况
            default:
                System.out.println("错误！");
        }
    }
}
