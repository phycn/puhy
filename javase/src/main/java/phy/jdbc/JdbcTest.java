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
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.236.150:1521/xe", "td", "td");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sys_user");
            //System.out.println(rs.getString(1) + " " + rs.getString(2));
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
