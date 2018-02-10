package cn.puhy.spring.transaction.annotationcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//事务增强
@Transactional
public class SpringTxAnnotationService {

    @Autowired
    private SpringTxAnnotationDao springTxAnnotationDao;

    //会覆盖类级别事务增强，txManager1为事务名
    @Transactional("txManager1")
    public void insert(SpringTxAnnotation springTxAnnotation) {
        springTxAnnotationDao.insert(springTxAnnotation);
    }

    //使用自定义事务管理器，实际事务为txManager1
    @TxManager1Transaction
    public void query() {

    }
}
