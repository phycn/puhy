package cn.puhy.spring.transaction.test;

import cn.puhy.spring.transaction.xmlcfg.SpringTxTest;
import cn.puhy.spring.transaction.xmlcfg.TxTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/puhy/spring/transaction/tx.xml")
public class XmlConfigTest {

    @Autowired
    private TxTestService txTestService;

    @Test
    public void insertTest() throws Exception {
        SpringTxTest springTxTest = new SpringTxTest();
        springTxTest.setField1("no-rollback-for不回滚");
        springTxTest.setField2("234");
        txTestService.insert(springTxTest);
    }
}
