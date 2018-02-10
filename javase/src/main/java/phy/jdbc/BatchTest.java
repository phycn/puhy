package phy.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

	public static void main(String[] args) {
		
		String sql1 = "insert into test1(column1,column2) values ('1', '111')";
		String sql2 = "insert into test1(column1,column2) values ('2', '222')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phy", "root", "root");
	    	Statement stmt = conn.createStatement();
	    	DatabaseMetaData dbmd = conn.getMetaData();
	    	//检查数据库是否支持批量更新
	    	System.out.println(dbmd.supportsBatchUpdates());
	    	
	    	stmt.addBatch(sql1);
	    	stmt.addBatch(sql2);
	    	//批量执行
	    	stmt.executeBatch();
	    	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
