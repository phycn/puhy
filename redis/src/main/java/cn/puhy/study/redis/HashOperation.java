package cn.puhy.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class HashOperation {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void phy() {
//        redisTemplate.opsForHash().
    }
}
