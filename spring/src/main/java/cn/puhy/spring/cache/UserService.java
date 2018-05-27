package cn.puhy.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author puhongyu
 * 2018/5/26 13:46
 */
@Service
public class UserService {
    //返回值可以被缓存，key为缓存的键，condition为条件，满足条件的才进行缓存
    @Cacheable(cacheNames = "user", key = "#id", condition = "#id < 2")
    public UserBean getUser(int id) throws InterruptedException {
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setName("蒲红宇" + id);
        userBean.setAddress("四川省成都市" + id);
        Thread.sleep(3000);
        System.out.println("处理中。。。");
        return userBean;
    }

    //每次都会执行方法把结果放入缓存中
    @CachePut(cacheNames = "user", key = "#id", condition = "#id < 2")
    public UserBean getUserPut(int id) throws InterruptedException {
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setName("蒲红宇" + id);
        userBean.setAddress("四川省成都市" + id);
        Thread.sleep(2000);
        System.out.println("处理中。。。");
        return userBean;
    }

    //移除缓存，allEntries为是否清除user所有缓存，beforeInvocation是否在方法执行前清空缓存
    @CacheEvict(cacheNames = "user", key = "#id", allEntries = false, beforeInvocation = false)
    public void removeUser(int id) {
        System.out.println("移除：" + id);
    }
}
