package com.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtility {

    private static Logger logger;

    private LoggerUtility() {
    }

    public static Logger getLogger(Class<?> clazz) {
        if (logger == null) {
            logger = LoggerFactory.getLogger(clazz);
        }
        return logger;
    }
}
