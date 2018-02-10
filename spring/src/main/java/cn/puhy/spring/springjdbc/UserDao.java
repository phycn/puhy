package cn.puhy.spring.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Spring JDBC更新数据
     */
    public void update() {
        String sql = "update user set password = ? where username = ?";
        Object[] params = {"phy2533", "admin"};
        //参数类型
        int[] types = {Types.VARCHAR, Types.VARCHAR};

        jdbcTemplate.update(sql, params, types);
    }

    /**
     * Spring JDBC新增数据，并返回自增主键值
     */
    public void insert() {
        final String sql = "insert into user (username, password) values (?, ?)";
        //创建一个主键持有者
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "puhongyu");
            ps.setString(2, "phy253399933");
            return ps;
        }, keyHolder);

        System.out.println("返回的主键值：" + keyHolder.getKey().intValue());
    }

    /**
     * 批量新增数据
     */
    public void batchInsert() {
        final String sql = "insert into user (username, password) values ('蒲红宇', ?)";
        List<String> passwords = new ArrayList<>(16);
        for (int i = 0; i < 10; i++) {
            passwords.add(String.valueOf(i));
        }

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String password = passwords.get(i);
                ps.setString(1, password);
            }

            //指定本批次的大小
            @Override
            public int getBatchSize() {
                return passwords.size();
            }
        });
    }
}
