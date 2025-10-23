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
                promocodes.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promocodes;
    }
}