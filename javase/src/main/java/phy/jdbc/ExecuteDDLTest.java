package phy.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDLTest {
    
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    public void initParam(String paramFile) throws Exception {
        
        Properties props = new Properties();
        //加载属性文件
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }
    
    public void createTable(String sql) throws Exception {
        
        //加载驱动
        Class.forName(driver);
        try(//获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            //创建Statement对象
            Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(sql);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    public static void main(String[] args) throws Exception {
        
        String sql = "create table jdbc_test ( jdbc_id int auto_increment primary key, jdbc_name varchar(255), jdbc_desc text);";
        ExecuteDDLTest ed = new ExecuteDDLTest();
        ed.initParam("mysql.ini");
        ed.createTable(sql);
        System.out.println("---建表成功---");
    }
}
