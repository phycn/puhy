package cn.puhy.mybatis.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import cn.puhy.mybatis.mapper.DynamicSqlMapper;
import cn.puhy.mybatis.model.SysUser;

public class DynamicSqlMapperTest extends BaseMapperTest {
	
	private static DynamicSqlMapper dynamicSqlMapper = sqlsession.getMapper(DynamicSqlMapper.class);
	
	//@Test
	public void testSelectByUser() {
		SysUser sysUser = new SysUser();
		sysUser.setUserName("红");
		sysUser.setUserEmail("phy25331@163.com");
		dynamicSqlMapper.selectByUser(sysUser);
	}
	
	//@Test
	public void testUpdateByIdSelective() {
		SysUser sysUser = new SysUser();
		sysUser.setUserPassword("173127");
		sysUser.setId(1);
		dynamicSqlMapper.updateByIdSelective(sysUser);
		sqlsession.commit();
	}
	
	//@Test
	public void testInsertSelective() {
		SysUser sysUser = new SysUser();
		sysUser.setCreateTime(new Date());
//		sysUser.setUserEmail("zhaoyi@puhy.cn");
		sysUser.setUserInfo("赵二");
		sysUser.setUserName("赵二");
		sysUser.setUserPassword("987654");
		
		dynamicSqlMapper.insertSelective(sysUser);
		System.out.println(sysUser.getId());
		sqlsession.commit();
	}
	
	//@Test
	public void testSelectByIdList() {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(3);
		dynamicSqlMapper.selectByIdList(idList);
	}
	
	//foreach实现批量插入
	@Test
	public void testInsertList() {
		List<SysUser> userList = new ArrayList<>();
		for(int i = 1; i < 4; i++) {
			SysUser sysUser = new SysUser();
			sysUser.setCreateTime(new Date());
			sysUser.setUserName("foreach测试" + i);
			userList.add(sysUser);
		}
		
		dynamicSqlMapper.insertList(userList);
		sqlsession.commit();
	}
	
	//foreach实现动态update,参数类型为map
	//@Test
	public void testUpdateByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 16);
		map.put("user_password", "999999");
		map.put("user_email", "17312782@qq.com");
		
		dynamicSqlMapper.updateByMap(map);
		sqlsession.commit();
	}
	
	//多数据库支持的查询
	//@Test
	public void testSelectMultiDatabase() {
		SysUser sysUser = new SysUser();
		sysUser.setUserName("for");
		dynamicSqlMapper.selectMultiDatabase(sysUser);
	}
	
	@AfterClass
	public static void close() {
		sqlsession.close();
		System.out.println("关闭sqlsession");
	}
}
