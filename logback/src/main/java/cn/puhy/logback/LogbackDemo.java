package cn.puhy.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author puhongyu
 * 2019-03-24 21:10
 */
public class LogbackDemo {

    private static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    static {
        MDC.put("traceid", "phy");
    }

    public static void main(String[] args) {
        logger.debug("121212");
    }
}
