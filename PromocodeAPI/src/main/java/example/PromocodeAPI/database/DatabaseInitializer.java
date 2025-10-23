package example.PromocodeAPI.database;

import java.sql.*;

public class DatabaseInitializer {
    private static final String URL = "jdbc:sqlite:promocodes.db";

    public static void initialize() {
        createTables();
        insertTestData();
    }

    private static void createTables() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            // Скрипт создания таблиц
            String sql = """
                CREATE TABLE IF NOT EXISTS promocodes (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    code TEXT NOT NULL UNIQUE,
                    length INTEGER NOT NULL,
                    activations INTEGER NOT NULL
                )
                """;
            stmt.execute(sql);
            System.out.println("Таблицы созданы!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertTestData() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            // Скрипт заполнения тестовыми данными
            String sql = """
                INSERT OR IGNORE INTO promocodes (code, length, activations) 
                VALUES 
                ('SUMMER2024', 10, 100),
                ('WELCOME10', 8, 50),
                ('DISCOUNT15', 11, 75)
                """;
            stmt.execute(sql);
            System.out.println("Тестовые данные добавлены!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}