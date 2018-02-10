package test;

import cn.puhy.springmvc.domain.User;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

public class AsyncControllerTest {

    public static void main(String[] args) {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

        //调用完后会立即返回，没有阻塞
        ListenableFuture<ResponseEntity<User>> future = asyncRestTemplate
                .getForEntity("http://localhost:8080/springmvc/async/handle1", User.class);

        //处理服务器端响应的异步回调方法
        future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("失败了");
            }

            @Override
            public void onSuccess(ResponseEntity<User> result) {
                System.out.println("回调消息：" + result.getBody());
            }
        });
    }
}
