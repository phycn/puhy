package cn.puhy.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import cn.puhy.mybatis.mapper.SysRoleMapper;

public class BaseMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	protected static SqlSession sqlsession;
	protected static SysRoleMapper sysRoleMapper;
	@BeforeClass
	public static void init() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//第二个参数指定加载数据库配置
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
			reader.close();
			sqlsession = getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
