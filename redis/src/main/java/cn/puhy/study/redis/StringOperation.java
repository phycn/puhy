package cn.puhy.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class StringOperation {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param time
     * @return
     */
    public boolean lock(String key, long time) {
        if (redisTemplate.opsForValue()
                .setIfAbsent(key, key, time, TimeUnit.MILLISECONDS)) {
            return true;
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     */
    public void unlock(String key) {
        redisTemplate.delete(key);
    }

    public void setKeyValue(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }
}
