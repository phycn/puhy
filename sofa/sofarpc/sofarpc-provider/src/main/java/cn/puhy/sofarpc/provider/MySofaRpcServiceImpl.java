package cn.puhy.sofarpc.provider;

import cn.puhy.sofarpc.api.MySofaRpcService;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Component;

/**
 * @author puhongyu
 * 2019/4/25 10:56
 */
@SofaService(interfaceType = MySofaRpcService.class, bindings = {@SofaServiceBinding(bindingType = "bolt"),
        @SofaServiceBinding(bindingType = "rest"),
        @SofaServiceBinding(bindingType = "dubbo")})
@Component
public class MySofaRpcServiceImpl implements MySofaRpcService {
    @Override
    public String sayHello() {
        System.out.println("invoke MySofaRpcService");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成...");
        return "hello phy!!";
    }
}
