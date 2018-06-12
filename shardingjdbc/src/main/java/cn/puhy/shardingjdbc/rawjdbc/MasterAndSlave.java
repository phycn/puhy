package cn.puhy.shardingjdbc.rawjdbc;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 读写分离
 *
 * @author puhongyu
 * 2018/6/10 13:49
 */
public class MasterAndSlave {
    public static void main(String[] args) throws SQLException {

        //配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        //配置主库数据源
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://182.61.34.102:3306/replication?characterEncoding=utf8");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");
        dataSourceMap.put("master", dataSource1);

        //配置从库数据源
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://117.48.203.244:3306/replication?characterEncoding=utf8");
        dataSource2.setUsername("root");
        dataSource2.setPassword("root");
        dataSourceMap.put("slave", dataSource2);

        //读写分离规则
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName("master_slave");
        masterSlaveRuleConfig.setMasterDataSourceName("master");
        masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("slave"));
        //从库负载均衡算法
//        masterSlaveRuleConfig.setLoadBalanceAlgorithmClassName("");

        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig,
                new ConcurrentHashMap<>());

        Connection conn = dataSource.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into user (name, age) values (?,?)");
        preparedStatement.setString(1, "李四");
        preparedStatement.setInt(2, 38);
        preparedStatement.executeUpdate();

        preparedStatement = conn.prepareStatement("select * from user where id = ?");
        preparedStatement.setInt(1, 2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }

        preparedStatement.close();
        conn.close();
    }
}
