package cn.puhy.sofarpc.provider;

import cn.puhy.sofarpc.api.MySofaRpcService;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Component;

/**
 * @author puhongyu
 * 2019/4/25 10:56
 */
@SofaService(interfaceType = MySofaRpcService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Component
public class MySofaRpcServiceImpl implements MySofaRpcService {
    @Override
    public String sayHello() {
        System.out.println("invoke MySofaRpcService");
        return "hello phy!!";
    }
}
