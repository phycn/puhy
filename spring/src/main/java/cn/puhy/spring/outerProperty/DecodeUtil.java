package cn.puhy.spring.outerProperty;

/**
 * 模拟加解密
 * @author puhongyu
 *
 */
public class DecodeUtil {
	
	public static String decode(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}
}
