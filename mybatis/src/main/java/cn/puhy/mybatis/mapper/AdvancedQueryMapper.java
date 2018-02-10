package cn.puhy.mybatis.mapper;

import java.util.List;

import cn.puhy.mybatis.model.OneToManySysUser;
import cn.puhy.mybatis.model.SysUser;

public interface AdvancedQueryMapper {
	
	SysUser selectUserAndRole1(Integer id);
	SysUser selectUserAndRole2(Integer id);
	SysUser selectUserAndRole3(Integer id);
	
	List<OneToManySysUser> selectUserAndRoleList(Integer id);
}
