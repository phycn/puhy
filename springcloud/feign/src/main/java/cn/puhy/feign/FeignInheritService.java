package cn.puhy.feign;

import cn.puhy.springcloud.common.service.InheritService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author PUHY
 * 2018-07-01 13:54
 */
@FeignClient("hello-service")
public interface FeignInheritService extends InheritService {
}
