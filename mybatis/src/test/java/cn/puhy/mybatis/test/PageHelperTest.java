package cn.puhy.mybatis.test;


import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Test;

import com.github.pagehelper.PageRowBounds;

import cn.puhy.mybatis.mapper.SysUserMapper;
import cn.puhy.mybatis.model.SysUser;

public class PageHelperTest extends BaseMapperTest {
	
	private static SqlSession sqlsession;
	private static SysUserMapper sysUserMapper;
	static {
		sqlsession = getSqlSession();
		sysUserMapper = sqlsession.getMapper(SysUserMapper.class);
	}
	
	@Test
	public void testSelectAllByRowBounds() {
		//使用RowBounds不会查询总数
//		RowBounds rowBounds = new RowBounds(1, 2);
//		List<SysUser> list = sysUserMapper.selectAll(rowBounds);
		
		//PageRowBounds会查询总数
		PageRowBounds pageRowBounds = new PageRowBounds(0, 2);
		sysUserMapper.selectAll(pageRowBounds);
		System.out.println(pageRowBounds.getTotal());
	}
	
	@AfterClass
	public static void close() {
		sqlsession.close();
		System.out.println("关闭sqlsession");
	}
}
