package example.PromocodeAPI.services;

import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.database.PromocodeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromocodeService {

    private PromocodeRepository repository = new PromocodeRepository();

    public List<Promocode> findAllPromocodes() {
        return repository.findAllPromocodes();
    }

    public String createPromocode(Promocode promocode) {
        // Логика создания
        System.out.println("Создаем промокод: " + promocode.getCode());
        System.out.println("Скидка: " + promocode.getDiscount() + "%");
        System.out.println("Описание: " + promocode.getDescription());
        System.out.println("Бизнес: " + promocode.getBusinessEmail());

        // Сохраняем в базу данных
        repository.savePromocode(promocode);

        return "Промокод " + promocode.getCode() + " создан!";
    }
}
