package org.ycz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycz.util.LogFactory;

public class LogbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        LogFactory.writeEnterLog("111","222");
        LogFactory.writeOutLog("111","222");
    }

}