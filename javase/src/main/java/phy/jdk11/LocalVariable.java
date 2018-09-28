package phy.jdk11;

/**
 * @author puhongyu
 * 2018/9/28 09:49
 */
public class LocalVariable {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        var phy = "phy";
        System.out.println(phy);
    }
}
