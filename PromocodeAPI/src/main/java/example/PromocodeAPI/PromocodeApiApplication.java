package example.PromocodeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import example.PromocodeAPI.database.DatabaseInitializer; // Импорт

@SpringBootApplication
public class PromocodeApiApplication {

    public static void main(String[] args) {
        DatabaseInitializer.initialize(); // Создаем БД и таблицы
        SpringApplication.run(PromocodeApiApplication.class, args);
    }
}