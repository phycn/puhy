package cn.puhy.spring.first.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.puhy.spring.first.domain.LoginLog;

@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(LoginLog loginLog) {
		
		String sql = "insert into t_login_log (user_id, ip, login_datetime) values (?, ?, ?)";
		//参数数组
		Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDatetime()};
		jdbcTemplate.update(sql, args);
	}
}
