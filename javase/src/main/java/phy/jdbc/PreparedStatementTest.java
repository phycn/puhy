package phy.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
   
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    private void initParam(String paramFile) throws Exception {
        
        Properties props = new Properties();
        //加载属性文件
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }
    
    private void insertUseStatement() throws Exception {
        
        long start = System.currentTimeMillis();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            for(int i = 0; i < 100; i++) {
                stmt.executeUpdate("insert into student_table values(null,'姓名"+i+"',1)");
            }
            System.out.println("使用statement耗时：" + (System.currentTimeMillis() - start));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void insertUsePrepare() throws Exception {
        
        long start = System.currentTimeMillis();
        Connection conn = DriverManager.getConnection(url, user, pass);
        //创建preparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null,?,2)");
        for(int i = 0; i < 100; i++) {
            pstmt.setString(1, "姓名" + i);
            pstmt.executeUpdate();
        }
        System.out.println("使用PreParedStatement耗时：" + (System.currentTimeMillis() - start));
    }
    
    public static void main(String[] args) throws Exception {
        
        PreparedStatementTest pt = new PreparedStatementTest();
        pt.initParam("mysql.ini");
        pt.insertUseStatement();
        pt.insertUsePrepare();
    }
}
