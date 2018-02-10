package cn.puhy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import cn.puhy.mybatis.model.Enabled;
import cn.puhy.mybatis.model.EnumSysRole;
import cn.puhy.mybatis.model.SysRole;
import cn.puhy.mybatis.provider.SysRoleProvider;

/**
 * 注解
 * @author PUHY
 *
 */
public interface SysRoleMapper {
	
	//@Results对应xml的resultMap
	@Results({
		//@Result对应result，id=true对应id属性
		@Result(property="id", column="id", id=true),
		@Result(property="roleName", column="role_name"),
		@Result(property="enabled", column="enabled"),
		@Result(property="createBy", column="create_by"),
		@Result(property="createTime", column="create_time")
	})
	//@Select注解，不需要再在xml中配置
	@Select({"select id, role_name, enabled, create_by, create_time from sys_role where id = #{id}"})
	SysRole selectById(Integer id);
	
	
	//不返回主键的insert
	@Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time) "
			+ "values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
	int insert1(SysRole sysRole);
	
	
	//返回自增主键
	@Insert({"insert into sys_role(role_name, enabled, create_by, create_time) "
			+ "values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
	//useGeneratedKeys,keyProperty和xml配置相同
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert2(SysRole sysRole);
	
	
	//返回非自增主键
	@Insert({"insert into sys_role(role_name, enabled, create_by, create_time) "
			+ "values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
	//与xml的selectKey配置一样，before为false等同于order="AFTER"
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", resultType=Integer.class, before=false)
	int insert3(SysRole sysRole);
	
	
	@Update({"update sys_role set role_name=#{roleName}, enabled=#{enabled}, "
			+ "create_by=#{createBy}, create_time=#{createTime, jdbcType=TIMESTAMP} where id=#{id}"})
	int updateById(SysRole sysRole);
	
	
	@Delete("delete from sys_role where id=#{id}")
	int deleteById(SysRole sysRole);
	
	
	//使用Provider注解
	@SelectProvider(type=SysRoleProvider.class, method="selectByIdProvider")
	SysRole selectByIdProvider(Integer id);
	
	//使用枚举
	List<EnumSysRole> selectByEnabled(Enabled enabled);
}
