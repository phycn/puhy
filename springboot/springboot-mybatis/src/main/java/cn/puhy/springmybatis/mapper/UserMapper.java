package cn.puhy.springmybatis.mapper;

import cn.puhy.springmybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author puhongyu
 * 2018/5/15 06:44
 */
@Mapper
public interface UserMapper {
    User queryById(int id);
}
