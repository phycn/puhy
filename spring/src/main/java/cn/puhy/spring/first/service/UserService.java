package cn.puhy.spring.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.puhy.spring.first.dao.LoginLogDao;
import cn.puhy.spring.first.dao.UserDao;
import cn.puhy.spring.first.domain.LoginLog;
import cn.puhy.spring.first.domain.User;

//标注为一个服务层的Bean
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean getMatchCount(String userName, String password) {
		int count = userDao.getMatchCount(userName, password);
		return count > 0;
	}
	
	public User selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}
	
	//事务注解，让该方法在事务环境中运行
	@Transactional
	public void loginSuccess(User user) {
		user.setCredits(user.getCredits() + 5);
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDatetime(user.getLastVisit());
		
		userDao.updateLoginInfo(user);
		loginLogDao.insert(loginLog);
	}
}
