package cn.puhy.datastructure.common;

/**
 * 暴力生成指定位数的密码
 *
 * @author PUHY
 * 2018-12-28 23:16
 */
public class BruteForce {

    //密码组成
    private static String[] characters = {"a", "b", "1"};

    /**
     *
     * @param count     密码位数
     * @param password
     */
    private static void generate(int count, String password) {

        if (count == 0) {
            System.out.println(password);
        } else {
            for (String character : characters) {
                String newStr = character + password;
                generate(count - 1, newStr);
            }
        }
    }

    public static void main(String[] args) {
        generate(3, "");
    }
}
