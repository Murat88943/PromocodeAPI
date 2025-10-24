package example.PromocodeAPI.database;

import example.PromocodeAPI.models.Promocode;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PromocodeRepository {

    private final JdbcClient jdbcClient;

    public PromocodeRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Promocode> findAllPromocodes() {
        return jdbcClient.sql("SELECT * FROM promocodes")
                .query(Promocode.class)
                .list();
    }

    public void savePromocode(Promocode promocode) {
        jdbcClient.sql("INSERT INTO promocodes (code, length, activations, description, discount, is_active, business_email) VALUES (?, ?, ?, ?, ?, ?, ?)")
                .param(promocode.getCode())
                .param(promocode.getLength())
                .param(promocode.getActivations())
                .param(promocode.getDescription())
                .param(promocode.getDiscount())
                .param(promocode.getIsActive())
                .param(promocode.getBusinessEmail())
                .update();
    }

    public void deletePromocode(Long promocodeId) {
        String sql = "DELETE FROM promocodes WHERE id = ?";
        jdbcClient.sql(sql).param(promocodeId).update();
    }
}
