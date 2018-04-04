package cn.puhy.mybatissourcestudy.test;

import cn.puhy.mybatissourcestudy.MybatisUser;
import cn.puhy.mybatissourcestudy.mapper.MybatisUser2Mapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author puhongyu
 * 2018/3/30 23:15
 */
public class MyBatisTest {

    @Test
    public void firstTest() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object object = sqlSession.selectOne("cn.puhy.mybatissourcestudy.queryById", 1);
        System.out.println(object instanceof MybatisUser);
    }

    @Test
    public void configurationTest() {
        Configuration configuration = new Configuration();
        InputStream inputStream = getClass().getResourceAsStream("/mybatisUser.xml");
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, "/mybatisUser.xml",
                configuration.getSqlFragments());
        builder.parse();
        MappedStatement mappedStatement = configuration.getMappedStatement("queryById");
        System.out.println(mappedStatement);
    }

    @Test
    public void getMapperTest() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MybatisUser2Mapper mapper = sqlSession.getMapper(MybatisUser2Mapper.class);
        Assert.assertNotNull(mapper.queryById(1));
    }
}
