package phy.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) throws InterruptedException {

		while (true) {
			Thread.sleep(1000);
			logger.debug("蒲红宇11112222");
			System.out.println("hehe nmb");
		}
	}
}
