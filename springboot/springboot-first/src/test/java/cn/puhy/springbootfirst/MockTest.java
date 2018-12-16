package cn.puhy.springbootfirst;

import cn.puhy.springbootfirst.service.PhyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author PUHY
 * 2018-12-16 17:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MockTest {

    @MockBean
    private PhyService phyService;

    @Test
    public void test() {
        // 指定@MockBean方法和参数，willReturn为虚拟对象
        BDDMockito.given(phyService.getName()).willReturn("puhongyu");
        Assert.assertEquals("puhongyu", phyService.getName());
    }
}
