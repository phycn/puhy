package cn.puhy.spring.first.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.puhy.spring.first.domain.User;

//通过spring注解定义一个dao
@Repository
public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	//自动注入JdbcTemplate的bean
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getMatchCount(String userName, String password) {
		
		String sql = "select count(*) from t_user where user_name = ? and password = ?";
		//spring高版本取消了queryForInt
		return jdbcTemplate.queryForObject(sql, new Object[] {userName, password}, Integer.class);
	}
	
	public User selectByUserName(String userName) {
		
		User user = new User();
		String sql = "select * from t_user where user_name = ?";
		//第2个参数为SQL语句中占位符对应的参数数组，第3个参数为查询结果的回调接口，这里有lambda表达式，负责映射
		jdbcTemplate.query(sql, new Object[] {userName}, (rs) -> {
			user.setUserId(rs.getInt("user_id"));
			user.setUserName("user_name");
			user.setCredits(rs.getInt("credits"));
			user.setLastIp(rs.getString("last_ip"));
			user.setLastVisit(rs.getDate("last_visit"));
		});
		return user;
	}
	
	public void updateLoginInfo(User user) {
		
		String sql = "update t_user set last_visit = ?, last_ip = ?, credits = ? where user_id = ?";
		jdbcTemplate.update(sql, new Object[] {user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
	}
}
