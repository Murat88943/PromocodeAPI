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

            // Обновленный скрипт создания таблицы с новыми полями
            String sql = """
                CREATE TABLE IF NOT EXISTS promocodes (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    code TEXT NOT NULL UNIQUE,
                    length INTEGER NOT NULL,
                    activations INTEGER NOT NULL,
                    description TEXT,
                    discount INTEGER,
                    is_active BOOLEAN DEFAULT true,
                    business_email TEXT
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

            // Обновленный скрипт с новыми полями
            String sql = """
                INSERT OR IGNORE INTO promocodes (code, length, activations, description, discount, is_active, business_email) 
                VALUES 
                ('SUMMER2024', 10, 100, 'Скидка на летнюю коллекцию', 20, true, 'summer@shop.com'),
                ('WELCOME10', 8, 50, 'Приветственная скидка для новых клиентов', 10, true, 'welcome@store.com'),
                ('DISCOUNT15', 11, 75, 'Скидка на все товары', 15, true, 'admin@mall.com')
                """;
            stmt.execute(sql);
            System.out.println("Тестовые данные добавлены!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}