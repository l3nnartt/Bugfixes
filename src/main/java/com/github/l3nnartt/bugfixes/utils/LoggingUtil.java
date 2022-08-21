package com.github.l3nnartt.bugfixes.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingUtil {

    private static final Logger LOGGER = Logger.getLogger("Bugfixes");
    private static final String PREFIX = "[Bugfixes] ";

    public static void init() {
        LOGGER.getParent().getHandlers()[0].setLevel(Level.ALL);
    }

    /**
     * Logs a message at the INFO level.
     *
     * @param message message to log at the INFO level
     */

    public static void info(String message) {
        LOGGER.info(PREFIX + message);
    }

    /**
     * Logs a message at the WARNING level.
     *
     * @param message message to log at the WARNING level
     */
    public static void warning(String message) {
        LOGGER.warning(PREFIX + message);
    }

    /**
     * Logs a message at the SEVERE level.
     *
     * @param message message to log at the SEVERE level
     */
    public static void error(String message) {
        LOGGER.severe(PREFIX + message);
    }
}