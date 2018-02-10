package phy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetPageTest {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.38:1521:kfdb", "emc", "emc");
    	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    	ResultSet rs = stmt.executeQuery("select * from phytest");
    	RowSetFactory factory = RowSetProvider.newFactory();
    	//创建默认的CachedRowSet实例
    	CachedRowSet cache = factory.createCachedRowSet();
    	//设置每页显示多少条记录
    	cache.setPageSize(2);
    	cache.populate(rs,1);
    	   	
    	while(cache.next()) {
    		System.out.println(rs.getString(1));
    	}
    	rs.close();
    	stmt.close();
    	conn.close();
	}
}
