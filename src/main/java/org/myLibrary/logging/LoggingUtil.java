package org.myLibrary.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingUtil {
    private static final Logger LOGGER = Logger.getLogger(LoggingUtil.class.getName());

    public static void logSevere(String message, Throwable throwable) {
        LOGGER.log(Level.SEVERE, message, throwable);
    }
    // ... autres méthodes pour différents niveaux de logging
}