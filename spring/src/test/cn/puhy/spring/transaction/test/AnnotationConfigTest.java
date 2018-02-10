package cn.puhy.spring.transaction.test;

import cn.puhy.spring.transaction.annotationcfg.SpringTxAnnotation;
import cn.puhy.spring.transaction.annotationcfg.SpringTxAnnotationService;
import cn.puhy.spring.transaction.xmlcfg.SpringTxTest;
import cn.puhy.spring.transaction.xmlcfg.TxTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/puhy/spring/transaction/annotation-tx.xml")
public class AnnotationConfigTest {

    @Autowired
    private SpringTxAnnotationService springTxAnnotationService;

    @Test
    public void insertTest() {

        SpringTxAnnotation springTxAnnotation = new SpringTxAnnotation();
        springTxAnnotation.setField1("蒲红宇");
        springTxAnnotation.setField2("嘿嘿嘿");
        springTxAnnotationService.insert(springTxAnnotation);
    }
}
