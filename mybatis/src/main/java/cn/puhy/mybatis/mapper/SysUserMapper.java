package cn.puhy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.puhy.mybatis.model.SysRole;
import cn.puhy.mybatis.model.SysUser;

public interface SysUserMapper {

	SysUser selectById(Integer id);
	List<SysUser> selectAll();
	//分页查询
	List<SysUser> selectAll(RowBounds rowBounds);
	List<SysRole> selectRolesByUserId(Integer userId);
	int insert(SysUser sysUser);
	int insertSelectKey(SysUser sysUser);
	int updateById(SysUser sysUser);
	int deleteById(SysUser sysUser);
	
	//多个参数需要加@Param
	List<SysRole> selectRolesByUserIdAndEnabled(@Param("userId")Integer userId, @Param("enabled")Integer enabled);
	
	//使用SQL代码段
	List<SysUser> selectBySqlSegment();
}
