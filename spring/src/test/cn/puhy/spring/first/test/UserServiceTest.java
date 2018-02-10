package cn.puhy.spring.first.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.puhy.spring.first.domain.User;
import cn.puhy.spring.first.service.UserService;

//启动spring容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:cn/puhy/spring/first/smart-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testGetMatchCount() {
		System.out.println("验证结果：" + userService.getMatchCount("admin", "123456"));
	}
	
	@Test
	public void testSelectByUserName() {
		userService.selectByUserName("admin");
	}
	
	@Test
	public void test() {
		boolean flag = userService.getMatchCount("admin", "123456");
		if(flag) {
			User user = userService.selectByUserName("admin");
			userService.loginSuccess(user);
		}
	}
}
