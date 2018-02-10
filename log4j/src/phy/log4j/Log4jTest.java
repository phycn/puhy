package phy.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		//System.out.println("test");
		logger.debug("testtest");
	}
}
