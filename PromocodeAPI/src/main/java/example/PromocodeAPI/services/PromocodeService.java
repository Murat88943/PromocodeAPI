package example.PromocodeAPI.services;

import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.database.PromocodeRepository; // Импорт репозитория
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromocodeService {

    private PromocodeRepository repository = new PromocodeRepository(); // Создаем экземпляр репозитория

    public List<Promocode> findAllPromocodes() {
        return repository.findAllPromocodes(); // Теперь получаем данные из БД через репозиторий
    }
}