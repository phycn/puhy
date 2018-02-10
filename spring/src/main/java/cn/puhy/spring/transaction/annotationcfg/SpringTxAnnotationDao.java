package cn.puhy.spring.transaction.annotationcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringTxAnnotationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(SpringTxAnnotation springTxAnnotation) {
        String sql = "insert into spring_tx_annotation (field1, field2) values (?, ?)";
        Object[] args = {springTxAnnotation.getField1(), springTxAnnotation.getField2()};
        jdbcTemplate.update(sql, args);
    }
}
