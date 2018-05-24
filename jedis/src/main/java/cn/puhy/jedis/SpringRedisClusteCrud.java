package cn.puhy.jedis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author puhongyu
 * 2018/5/22 21:02
 */
public class SpringRedisClusteCrud {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-redis-cluster.xml");
        context.start();

        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        System.out.println(redisTemplate.opsForValue().get("phy"));
    }
}
