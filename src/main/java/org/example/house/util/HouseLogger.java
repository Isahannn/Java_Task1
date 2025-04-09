package org.example.house.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HouseLogger {
    private static final Logger logger = LogManager.getLogger(HouseLogger.class);

    public static Logger getLogger() {
        return logger;
    }
}