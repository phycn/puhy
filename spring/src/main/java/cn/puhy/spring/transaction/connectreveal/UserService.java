package cn.puhy.spring.transaction.connectreveal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

@Service("userService")
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional("txManager1")
    public void login(String userName) throws SQLException, InterruptedException {
        //直接从数据源获取连接，后续也没有释放，连接会一直占用
//        Connection conn = jdbcTemplate.getDataSource().getConnection();

        //事务环境下通过DataSourceUtils获取数据连接，会获取方法所在事务上下文绑定的那个连接，而不是新建连接
        //非事务环境下是不会释放的
        Connection conn1 = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        String sql = "update user set phone = ? where username = ?";
        jdbcTemplate.update(sql, "15680609933", userName);

        //模拟程序执行时间
        Thread.sleep(5000);
    }
}
