package cn.puhy.mybatis.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.puhy.mybatis.mapper.SysUserMapper;
import cn.puhy.mybatis.model.SysUser;

public class SysUserMapperTest extends BaseMapperTest {

	@Test
	public void testSelectById() {
		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		SysUser user = sysUserMapper.selectById(1);
		System.out.println("------------------------------------------------------");
		List<SysUser> users = sysUserMapper.selectAll();
		System.out.println("------------------------------------------------------");
		sysUserMapper.selectRolesByUserId(1);
		sqlsession.close();
	}

	//@Test
	public void testInsert() {

		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		SysUser sysUser = new SysUser();
		sysUser.setUserName("蒲红宇1");
		sysUser.setUserPassword("253399");
		sysUser.setUserEmail("phy2533@163.com");
		sysUser.setUserInfo("puhongyu");
		sysUser.setHeadImg(new byte[] { 1, 2, 3 });
		sysUser.setCreateTime(new Date());

		sysUserMapper.insert(sysUser);
		// 提交
		sqlsession.commit();
		System.out.println(sysUser.getId());
		sqlsession.close();
	}

	//@Test
	public void testInsertSelectKey() {

		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		SysUser sysUser = new SysUser();
		sysUser.setUserName("蒲红宇2");
		sysUser.setUserPassword("253399");
		sysUser.setUserEmail("phy2533@163.com");
		sysUser.setUserInfo("puhongyu");
		sysUser.setHeadImg(new byte[] { 1, 2, 3 });
		sysUser.setCreateTime(new Date());

		sysUserMapper.insertSelectKey(sysUser);
		// 提交
		sqlsession.commit();
		System.out.println(sysUser.getId());
		sqlsession.close();
	}
	
	//@Test
	public void testUpdateById() {
		
		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		SysUser sysUser = new SysUser();
		
		sysUser.setId(8);
		sysUser.setUserName("蒲红宇3");
		sysUser.setUserPassword("253399");
		sysUser.setUserEmail("phy2533@163.com");
		sysUser.setUserInfo("puhongyu");
		sysUser.setHeadImg(new byte[] { 1, 2, 3 });
		sysUser.setCreateTime(new Date());

		sysUserMapper.updateById(sysUser);
		// 提交
		sqlsession.commit();
		sqlsession.close();
	}
	
	//@Test
	public void testDeleteById() {
		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		SysUser sysUser = new SysUser();
		
		sysUser.setId(9);
		sysUserMapper.deleteById(sysUser);
		
		sqlsession.commit();
		sqlsession.close();
	}
	
	//@Test
	public void testSelectRolesByUserIdAndEnabled() {
		
		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		
		sysUserMapper.selectRolesByUserIdAndEnabled(1, 1);
	}
	
	@Test
	public void testSelectBySqlSegment() {
		SqlSession sqlsession = getSqlSession();
		SysUserMapper sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
		sysUserMapper.selectBySqlSegment();
	}
}
