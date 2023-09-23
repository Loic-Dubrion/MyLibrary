package org.myLibrary.exception;

import java.sql.SQLException;

public class ExceptionHandler {

    public static void handleException(Throwable throwable) {
        if (throwable instanceof SQLException) {
            System.err.println("Database access error: " + throwable.getMessage());
        } else {
            System.err.println("Unexpected error: " + throwable.getMessage());
        }
        // Optionally, log the exception to a file or monitoring system.
    }
}
