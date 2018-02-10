package cn.puhy.spring.transaction.test;

import cn.puhy.spring.transaction.annotationcfg.SpringTxAnnotation;
import cn.puhy.spring.transaction.annotationcfg.SpringTxAnnotationService;
import cn.puhy.spring.transaction.connectreveal.JdbcService;
import cn.puhy.spring.transaction.connectreveal.UserService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/puhy/spring/transaction/annotation-tx.xml")
public class ConnectRevealTest {

    @Autowired
    private JdbcService jdbcService;

    @Autowired
    private BasicDataSource basicDataSource;

    @Autowired
    private UserService userService;

    @Test
    public void test() throws InterruptedException {

        jdbcService.reportConn(basicDataSource);
        //启动一个异步线程A
        jdbcService.asyncLogin(userService, "admin");
        jdbcService.sleep(2000);

        //此时线程A还未执行完，连接数为2
        jdbcService.reportConn(basicDataSource);
        //线程A执行完，但是连接数还有1个，因为直接获取到的Connection没有释放
        jdbcService.sleep(4000);

        jdbcService.reportConn(basicDataSource);

        //启动一个异步线程B
        jdbcService.asyncLogin(userService, "admin1");
        jdbcService.sleep(2000);

        jdbcService.reportConn(basicDataSource);
        jdbcService.sleep(4000);

        jdbcService.reportConn(basicDataSource);
    }
}
