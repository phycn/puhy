package phy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetTest {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.55:1521:kfdb", "af", "af");
    	//结果集可滚动，可更新
    	//oracle数据库不能select * from table,就是不能用*
        PreparedStatement stmt = conn.prepareStatement("select channel_no from AF_CONTROL_BOOK", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery();
        rs.last();
        int rowCount = rs.getRow();
        for(int i = rowCount; i >0; i--) {
        	//移动到指定行
        	rs.absolute(i);
        	//修改第1列的值
        	rs.updateString(1, "20");
        	//提交修改
        	rs.updateRow();
        }
        
        rs.close();
        stmt.close();
        conn.close();
	}
}
