package cn.puhy.sofarpc.consumer;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.invoke.SofaResponseCallback;
import com.alipay.sofa.rpc.core.request.RequestBase;
import org.springframework.stereotype.Component;

/**
 * 异步回调
 *
 * @author puhongyu
 * 2019/4/26 11:04
 */
@Component("myCallback")
public class MyCallback implements SofaResponseCallback {

    // 当客户端接收到服务端的正常返回的时候，SOFARPC 会回调这个方法
    @Override
    public void onAppResponse(Object o, String s, RequestBase requestBase) {
        System.out.println("provider处理完回调了");
    }

    // 当客户端接收到服务端的异常响应的时候，SOFARPC 会回调这个方法
    @Override
    public void onAppException(Throwable throwable, String s, RequestBase requestBase) {
        System.out.println("异常");
    }

    // 当 SOFARPC 本身出现一些错误，比如路由错误的时候，SOFARPC 会回调这个方法
    @Override
    public void onSofaException(SofaRpcException e, String s, RequestBase requestBase) {
        System.out.println("异常");
    }
}
