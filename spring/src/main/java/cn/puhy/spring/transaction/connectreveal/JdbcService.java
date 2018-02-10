package cn.puhy.spring.transaction.connectreveal;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("jdbcService")
public class JdbcService {

    /**
     * 以异步方式执行
     *
     * @param userService
     * @param userName
     */
    public void asyncLogin(UserService userService, String userName) {
        UserServiceRunner userServiceRunner = new UserServiceRunner(userService, userName);
        userServiceRunner.start();
    }

    /**
     * 让主线程睡眠一段时间
     *
     * @param time
     * @throws InterruptedException
     */
    public void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    /**
     * 统计数据源的连接占用情况
     *
     * @param basicDataSource
     */
    public void reportConn(BasicDataSource basicDataSource) {
        System.out.println("连接数：" + basicDataSource.getNumActive() + "|闲置数：" + basicDataSource.getNumIdle());
    }
}

class UserServiceRunner extends Thread {

    private UserService userService;
    private String userName;

    public UserServiceRunner(UserService userService, String userName) {
        this.userService = userService;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            userService.login(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
