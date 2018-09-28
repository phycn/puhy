package phy.jdk11;

/**
 * @author puhongyu
 * 2018/9/28 10:02
 */
public class StringReinforce {

    public static void main(String[] args) {
        // 判断字符串是否为空白
        System.out.println("  ".isBlank());
        // 去除首尾空格
        System.out.println(" puhongyu ".strip());
        // 去除尾部空格
        System.out.println(" phy ".stripTrailing());
        // 去除首部空格
        System.out.println(" phy ".stripLeading());
        // 复制字符串
        System.out.println("phy".repeat(3));
        // 行数统计
        System.out.println("A\nB\nC".lines().count());
    }
}
