package cn.puhy.study.springsourcestudy.test;

import cn.puhy.study.springsourcestudy.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author puhongyu
 * 2018/3/21 23:38
 */
public class BeanFactoryTest {

    @Test
    public void getBeanTest() {
        //初始化工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //加载
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //查看BeanDefinition加载解析注册过程断点打在DefaultListableBeanFactory.registerBeanDefinition
        reader.loadBeanDefinitions("context.xml");
        //查看bean的创建断点打在UserDao的构造方法
        factory.getBean(UserDao.class);
    }
}
