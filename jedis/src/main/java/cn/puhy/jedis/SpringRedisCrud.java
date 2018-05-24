package cn.puhy.jedis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author puhongyu
 * 2018/5/22 21:02
 */
public class SpringRedisCrud {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-redis.xml");
        context.start();
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);

        //操作字符串
        redisTemplate.opsForValue();
        //操作列表
        redisTemplate.opsForList();
        //操作哈希
        redisTemplate.opsForHash();
        //操作集合
        redisTemplate.opsForSet();
        //操作有序集合
        redisTemplate.opsForZSet();
    }
}
