package cn.puhy.spring.transaction.xmlcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxTestService {

    @Autowired
    private SpringTxTestDao springTxTestDao;

    public void insert(SpringTxTest springTxTest) throws Exception {
        springTxTestDao.insert(springTxTest);
    }
}
