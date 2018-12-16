package cn.puhy.springbootstartertest;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author PUHY
 * 2018-12-16 19:35
 */
@Component
public class PhyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        try {
            InetAddress.getByName("www.baidu2533.com").isReachable(3000);
            builder.withDetail("message", "百度服务可用").up();
        } catch (Exception e) {
            builder.withDetail("message", "百度服务不可用").outOfService();
        }
    }
}
