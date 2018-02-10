package cn.puhy.spring.transaction;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Collection;

public class JDBCTransaction {

    public static void main(String[] args) throws SQLException {

        //spring数据源实现类
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/phy");
        ds.setUsername("root");
        ds.setPassword("root");
        Connection conn = ds.getConnection();

        //获取数据库信息
        DatabaseMetaData dmd = conn.getMetaData();
        //设置事务隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        //保存点
        Savepoint sp = conn.setSavepoint("sp");
        //回滚到保存点
        conn.rollback(sp);
        //关闭自动提交
        conn.setAutoCommit(false);
    }

    public void test() {

    }
}
