package phy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {
	
	private static CachedRowSet query() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.38:1521:kfdb", "emc", "emc");
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("select * from phytest");
    	RowSetFactory factory = RowSetProvider.newFactory();
    	//创建默认的CachedRowSet实例
    	CachedRowSet cache = factory.createCachedRowSet();
    	//将ResultSet装填进去
    	cache.populate(rs);
    	
    	rs.close();
    	stmt.close();
    	conn.close();
    	
    	return cache;
	}
	
	public static void main(String[] args) throws Exception {
		
		CachedRowSet rs = query();
		rs.afterLast();
		while(rs.previous()) {
			System.out.println(rs.getString(1));
			//修改指定列
			rs.updateString("f2", "phy");
			rs.updateRow();
		}
		//重新获取数据库连接
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.38:1521:kfdb", "emc", "emc");
		conn.setAutoCommit(false);
		//同步到数据库
		rs.acceptChanges(conn);
	}
}
