package cn.puhy.springmvc.domain;

import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

/**
 * User对象转换器，将字符串转换为User对象
 * Converter接口泛型第一个为源对象，第二个为目标对象
 *
 * @author puhongyu
 * 2018/1/30 20:09
 */
public class StringToUserConverter implements Converter<String, User> {

    @Override
    public User convert(String source) {
        System.out.println("原字符串：" + source);
        User user = new User();

        //将字符串以|分隔
        String[] items = source.split(":");
        user.setName(items[0]);
        user.setAddress(items[1]);
        user.setPassword(items[2]);

        return user;
    }
}
