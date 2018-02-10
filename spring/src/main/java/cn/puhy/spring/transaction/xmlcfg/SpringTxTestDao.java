package cn.puhy.spring.transaction.xmlcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringTxTestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(SpringTxTest springTxTest) throws Exception {

        String sql = "insert into spring_tx_test (field1, field2) values (?, ?)";
        Object[] args = {springTxTest.getField1(), springTxTest.getField2()};
        jdbcTemplate.update(sql, args);
        //抛出异常，如果rollback-for设置的异常为Excption，则会回滚，反之no-rollback-for
        throw new Exception("异常");
    }
}
