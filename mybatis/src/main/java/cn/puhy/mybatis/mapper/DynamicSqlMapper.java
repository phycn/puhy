package cn.puhy.mybatis.mapper;

import java.util.List;
import java.util.Map;

import cn.puhy.mybatis.model.SysUser;

public interface DynamicSqlMapper {

	List<SysUser> selectByUser(SysUser sysUser);
	int updateByIdSelective(SysUser sysUser);
	int insertSelective(SysUser sysUser);
	//collection为list时参数为List
	List<SysUser> selectByIdList(List<Integer> idList);
	//foreach实现批量插入
	int insertList(List<SysUser> userList);
	
	//foreach实现动态update,参数类型为map
	int updateByMap(Map<String, Object> map);
	
	//多数据库支持的查询
	List<SysUser> selectMultiDatabase(SysUser sysUser);
}
