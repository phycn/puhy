package cn.puhy.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.puhy.mybatis.mapper.SysUserMapper;
import cn.puhy.mybatis.model.SysUser;

import org.junit.AfterClass;
import org.junit.Assert;

public class CacheTest extends BaseMapperTest {
	
	private static SqlSession sqlsession;
	private static SysUserMapper sysUserMapper;
	static {
		sqlsession = getSqlSession();
		sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
	}
	
	//一级缓存
	//@Test
	public void testL1Cache() {
		
		SysUser user1 = sysUserMapper.selectById(4);
		user1.setUserName("hehe");
		SysUser user2 = sysUserMapper.selectById(4);
		//user1和user2一模一样
		Assert.assertEquals(user1, user2);
	}
	
	//二级缓存
	@Test
	public void testL2Cache() {
		
		SysUser user1 = sysUserMapper.selectById(4);
		user1.setUserName("hehe");
		SysUser user2 = sysUserMapper.selectById(4);
		//user1和user2一模一样
		Assert.assertEquals(user1, user2);
		
		sqlsession.close();
		sqlsession = getSqlSession();
		sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		
		SysUser user3 = sysUserMapper.selectById(4);
		SysUser user4 = sysUserMapper.selectById(4);
		//user3和user4是反序列化的结果，不一样
		Assert.assertNotEquals(user3, user4);
	}
	
	@AfterClass
	public static void close() {
		sqlsession.close();
		System.out.println("关闭sqlsession");
	}
}
