package cn.puhy.sofarpc.consumer;

import cn.puhy.sofarpc.api.MySofaRpcService;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author puhongyu
 * 2019/4/26 09:47
 */
@SpringBootApplication
public class SofaRpcConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SofaRpcConsumerApplication.class);

        ConsumerConfig<MySofaRpcService> consumerConfig = new ConsumerConfig<>();
    }
}
