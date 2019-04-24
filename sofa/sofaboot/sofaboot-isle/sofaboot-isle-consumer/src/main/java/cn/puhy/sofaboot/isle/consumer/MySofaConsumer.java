package cn.puhy.sofaboot.isle.consumer;

import cn.puhy.sofaboot.isle.api.MySofaService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;

/**
 * @author puhongyu
 * 2019/4/24 15:51
 */
public class MySofaConsumer {

    @SofaReference(uniqueId = "mySofaServiceImpl")
    private MySofaService mySofaService;

    public void sayHello() {
        System.out.println(mySofaService.sayHello());
    }
}
