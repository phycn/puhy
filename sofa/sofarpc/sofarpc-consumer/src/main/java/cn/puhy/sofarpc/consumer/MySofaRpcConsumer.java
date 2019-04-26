package cn.puhy.sofarpc.consumer;

import cn.puhy.sofarpc.api.MySofaRpcService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.stereotype.Component;

/**
 * @author puhongyu
 * 2019/4/26 09:45
 */
@Component
public class MySofaRpcConsumer {

    // 服务引用
    // @SofaReferenceBinding(bindingType = "bolt", invokeType = "future", , timeout = 2000)
    // bindingType 协议
    // invokeType future-异步，callback-回调
    // timeout 超时时间
    // callbackRef 回调实例
    @SofaReference(interfaceType = MySofaRpcService.class,
            binding = @SofaReferenceBinding(bindingType = "bolt", invokeType = "callback",
                    timeout = 10000, callbackClass = "MyCallback"))
    private MySofaRpcService mySofaRpcService;

    public String consumer() {
        System.out.println("consumer invoke provider");
        return mySofaRpcService.sayHello();
    }
}
