package cn.puhy.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author puhongyu
 * 2018/4/3 21:33
 */
public class Log4j2 {

    private static Logger logger = LoggerFactory.getLogger(Log4j2.class);

    public static void main(String[] args) {
        logger.debug("debug info");
        logger.info("info info");
    }
}
