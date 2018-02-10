package phy.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetFactoryTest {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.55:1521:kfdb", "af", "af");
    	RowSetFactory factory = RowSetProvider.newFactory();
    	JdbcRowSet jdbcrs = factory.createJdbcRowSet();
    	jdbcrs.setUrl("jdbc:oracle:thin:@192.168.20.38:1521:kfdb");
    	jdbcrs.setUsername("emc");
    	jdbcrs.setPassword("emc");
    	jdbcrs.setCommand("select * from phytest");
    	jdbcrs.execute();
    	
    	jdbcrs.afterLast();
    	//向前滚动结果集
    	while(jdbcrs.previous()) {
    		System.out.println(jdbcrs.getString(1));
    		//修改指定列
    		jdbcrs.updateString("f1", "f11");
    		jdbcrs.updateRow();
    	}
    	
    	jdbcrs.close();
	}
}
