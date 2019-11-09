package phy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
        
        //会自动关闭资源
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://rm-bp14y74mzukx08319.mysql.rds.aliyuncs.com:3306/sheer",
                    "mt", "pbcMysqlPwd668!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select DISTINCT userId from t_star_record");
            //System.out.println(rs.getString(1) + " " + rs.getString(2));
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
