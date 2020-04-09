package phy.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author puhongyu
 * 2018/9/28 10:29
 */
public class HttpClient11 {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        var request = HttpRequest.newBuilder()
//                .uri(URI.create("http://baidu.com/"))
//                .GET()
//                .build();
//        var client = HttpClient.newHttpClient();
//
//        // 同步
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//
//        // 异步
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);
//    }
}
