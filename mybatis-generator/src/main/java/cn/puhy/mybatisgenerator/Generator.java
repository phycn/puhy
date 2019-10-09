package cn.puhy.mybatisgenerator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {

        List<String> warns = new ArrayList<>();
        File file = new File(Generator.class.getClassLoader().getResource("mybatis-generator.xml").getFile());
        ConfigurationParser cp = new ConfigurationParser(warns);
        Configuration configuration = cp.parseConfiguration(file);

        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warns);
        generator.generate(null);
        for (String warn : warns) {
            System.out.println(warn);
        }
    }
}
