package cn.puhy.mybatis.test;

import cn.puhy.mybatis.model.OneToManySysUser;
import org.junit.AfterClass;
import org.junit.Test;

import cn.puhy.mybatis.mapper.AdvancedQueryMapper;
import cn.puhy.mybatis.model.SysUser;

import java.util.List;

public class AdvancedQueryMapperTest extends BaseMapperTest {
	
	private AdvancedQueryMapper mapper = sqlsession.getMapper(AdvancedQueryMapper.class);
	
	//@Test
	public void testSelectUserAndRole1() {
		
		mapper.selectUserAndRole1(2);
	}
	
	//@Test
	public void testSelectUserAndRole2() {
		
		mapper.selectUserAndRole2(2);
	}
	
	@Test
	public void testSelectUserAndRole3() {
		
		SysUser sysUser = mapper.selectUserAndRole3(1);
		System.out.println("调用getSysRole，延迟加载");
		System.out.println(sysUser.getSysRole());
	}
	
	@Test
	public void testSelectUserAndRoleList() {
		
		List<OneToManySysUser> list = mapper.selectUserAndRoleList(111);
		System.out.println(list == null);
	}
	
	@AfterClass
	public static void close() {
		sqlsession.close();
		System.out.println("关闭sqlsession");
	}
}
