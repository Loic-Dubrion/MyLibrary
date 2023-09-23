package org.myLibrary.data.connection;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;

    static {
        Dotenv dotenv = Dotenv.load();

        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
