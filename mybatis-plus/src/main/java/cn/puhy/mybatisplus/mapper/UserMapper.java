package cn.puhy.mybatisplus.mapper;

import cn.puhy.mybatisplus.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author puhongyu
 * 2018/5/15 06:44
 */
@Mapper
public interface UserMapper {
    User queryById(int id);
}
