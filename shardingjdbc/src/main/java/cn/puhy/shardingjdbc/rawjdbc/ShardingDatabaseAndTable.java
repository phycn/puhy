package cn.puhy.shardingjdbc.rawjdbc;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 原生JDBC分表
 *
 * @author puhongyu
 * 2018/6/10 08:36
 */
public class ShardingDatabaseAndTable {
    public static void main(String[] args) throws SQLException {

        String sql = "insert into t_order (user_id, status, address_id) values (?,?,?)";

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置数据源1
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/sharding_0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");
        dataSourceMap.put("sharding_0", dataSource1);

        // 配置数据源2
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://localhost:3306/sharding_1");
        dataSource2.setUsername("root");
        dataSource2.setPassword("root");
        dataSourceMap.put("sharding_1", dataSource2);

        //配置t_order表的分表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        //逻辑表名称
        orderTableRuleConfig.setLogicTable("t_order");
        //数据节点，数据源名称+真实表名称
        orderTableRuleConfig.setActualDataNodes("sharding_${[0, 1]}.t_order_${[0, 1]}");
        //自增列名称，缺省表示不使用自增主键生成器
        orderTableRuleConfig.setKeyGeneratorColumnName("order_id");
        //自增列值生成器，缺省表示使用默认自增主键生成器
//        orderTableRuleConfig.setKeyGeneratorClass();
        //分库策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(
                new StandardShardingStrategyConfiguration("address_id", ShardingDatabaseAlgorithm.class.getName(), RangeAlgorithm.class.getName()));
        //分表策略，使用行表达式分片策略，根据user_id字段进行取模
//        orderTableRuleConfig.setTableShardingStrategyConfig(
//                new InlineShardingStrategyConfiguration("user_id", "t_order_${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(
                new StandardShardingStrategyConfiguration("user_id", ShardingDatabaseAlgorithm.class.getName(), RangeAlgorithm.class.getName()));
        //配置分库分表规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        //配置读写分离
//        shardingRuleConfig.setMasterSlaveRuleConfigs();

        Properties properties = new Properties();
        //开启SQL显示
        properties.put("sql.show", "true");
        //获取数据源对象
        DataSource dataSource = ShardingDataSourceFactory.
                createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), properties);

        Connection conn = dataSource.getConnection();
        /*PreparedStatement preparedStatement = conn.prepareStatement(sql);

        for (int i = 0; i < 10; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "puhy");
            preparedStatement.setInt(3, 11);
            preparedStatement.executeUpdate();
        }*/

        PreparedStatement preparedStatement = conn.prepareStatement("select * from t_order where user_id between 1 and 8");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getLong(1) +
                    " " + resultSet.getInt(2) +
                    " " + resultSet.getString(3) +
                    " " + resultSet.getInt(4));
        }

        preparedStatement.close();
        conn.close();
    }
}
