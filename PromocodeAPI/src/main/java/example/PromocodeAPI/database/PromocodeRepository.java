package example.PromocodeAPI.database;

import example.PromocodeAPI.models.Promocode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromocodeRepository {
    private static final String URL = "jdbc:sqlite:promocodes.db";

    public List<Promocode> findAllPromocodes() {
        List<Promocode> promocodes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM promocodes")) {

            while (rs.next()) {
                Promocode promo = new Promocode();
                promo.setId(rs.getLong("id"));
                promo.setCode(rs.getString("code"));
                promo.setLength(rs.getInt("length"));
                promo.setActivations(rs.getInt("activations"));
                promo.setDescription(rs.getString("description"));
                promo.setDiscount(rs.getInt("discount"));
                promo.setIsActive(rs.getBoolean("is_active"));
                promo.setBusinessEmail(rs.getString("business_email"));
                promocodes.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promocodes;
    }

    // Добавляем метод для сохранения промокода
    public void savePromocode(Promocode promocode) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO promocodes (code, length, activations, description, discount, is_active, business_email) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, promocode.getCode());
            stmt.setInt(2, promocode.getLength());
            stmt.setInt(3, promocode.getActivations());
            stmt.setString(4, promocode.getDescription());
            stmt.setInt(5, promocode.getDiscount());
            stmt.setBoolean(6, promocode.getIsActive());
            stmt.setString(7, promocode.getBusinessEmail());

            stmt.executeUpdate();
            System.out.println("Промокод сохранен в БД: " + promocode.getCode());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}