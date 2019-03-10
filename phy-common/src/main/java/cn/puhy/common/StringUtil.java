package cn.puhy.common;

public class StringUtil {

    public static boolean isBlank(String str) {
        return str == null || "".equals(str);
    }
}
