package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:enterprise.db";

    public static void createTables() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("SQLite JDBC driver not found");
            return;
        }
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            String createGroupTable = "CREATE TABLE IF NOT EXISTS groups (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "number INTEGER);";
            statement.executeUpdate(createGroupTable);

            String createChildTable = "CREATE TABLE IF NOT EXISTS children (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "gender TEXT," +
                    "age INTEGER," +
                    "group_id INTEGER," +
                    "FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE);";
            statement.executeUpdate(createChildTable);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    // Other methods remain unchanged, but you might need to update SQL queries accordingly
    // based on the structure of your Java classes.
    // For example, saveGroup, loadAllGroups, updateGroup, removeGroup, etc.
}