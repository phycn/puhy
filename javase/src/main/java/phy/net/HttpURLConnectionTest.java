package phy.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author PUHY
 * 2019-04-05 20:38
 */
public class HttpURLConnectionTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8081/method2");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("phy", "puhongyu");
        conn.connect();

        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();
            // 封装输入流is，并指定字符集
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 存放数据
            StringBuffer sbf = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            System.out.println(sbf.toString());
        }
    }
}
