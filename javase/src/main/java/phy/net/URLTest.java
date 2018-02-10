package phy.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLTest {

    public static void main(String[] args) {

        try {
            String urlStr = URLEncoder.encode("最高人民法院", "UTF-8");
            System.out.println(urlStr);
            //String a = "%E5%A1%94%E6%8B%89%E5%A4%9A%E5%B9%BD%E5%85%B0";
            //String name = URLDecoder.decode(a, "UTF-8");
            //System.out.println(name);
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }
}
