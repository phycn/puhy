package cn.puhy.mybatis.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.puhy.mybatis.mapper.SysRoleMapper;
import cn.puhy.mybatis.model.Enabled;
import cn.puhy.mybatis.model.SysRole;

public class SysRoleMapperTest extends BaseMapperTest {
	
	private static SqlSession sqlsession;
	private static SysRoleMapper sysRoleMapper;
	static {
		sqlsession = getSqlSession();
		sysRoleMapper = sqlsession.getMapper(SysRoleMapper.class);
	}

	//@Test
	public void testSelectById() {
		sysRoleMapper.selectById(1);
		sqlsession.close();
	}
	
	//@Test
	public void testInsert1() {
		SysRole sysRole = new SysRole();
		sysRole.setCreateBy(1);
		sysRole.setCreateTime(new Date());
		sysRole.setEnabled(1);
		sysRole.setRoleName("测试管理员");
		
		sysRoleMapper.insert1(sysRole);
		sqlsession.commit();
		sqlsession.close();
	}
	
	//@Test
	public void testInsert2() {
		SysRole sysRole = new SysRole();
		sysRole.setCreateBy(1);
		sysRole.setCreateTime(new Date());
		sysRole.setEnabled(1);
		sysRole.setRoleName("测试管理员2");
		
		sysRoleMapper.insert2(sysRole);
		sqlsession.commit();
		//返回自增主键
		System.out.println(sysRole.getId());
		sqlsession.close();
	}
	
	//@Test
	public void testInsert3() {
		SysRole sysRole = new SysRole();
		sysRole.setCreateBy(1);
		sysRole.setCreateTime(new Date());
		sysRole.setEnabled(1);
		sysRole.setRoleName("测试管理员3");
		
		sysRoleMapper.insert3(sysRole);
		sqlsession.commit();
		//返回自增主键
		System.out.println(sysRole.getId());
		sqlsession.close();
	}
	
	//@Test
	public void testSelectByIdProvider() {
		sysRoleMapper.selectByIdProvider(1);
		sqlsession.close();
	}
	
	@Test
	public void testSelectByEnabled() {
		//使用枚举类型
		sysRoleMapper.selectByEnabled(Enabled.enabled);
		sqlsession.close();
	}
}
