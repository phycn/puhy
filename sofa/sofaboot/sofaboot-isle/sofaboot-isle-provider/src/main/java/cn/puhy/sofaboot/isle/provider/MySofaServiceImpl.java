package cn.puhy.sofaboot.isle.provider;

import cn.puhy.sofaboot.isle.api.MySofaService;
import com.alipay.sofa.runtime.api.annotation.SofaService;

/**
 * @author puhongyu
 * 2019/4/24 15:24
 */
@SofaService(uniqueId = "mySofaServiceImpl")
public class MySofaServiceImpl implements MySofaService {
    @Override
    public String sayHello() {
        System.out.println("invoke MySofaServiceImpl");
        return "hello puhongyu";
    }
}
