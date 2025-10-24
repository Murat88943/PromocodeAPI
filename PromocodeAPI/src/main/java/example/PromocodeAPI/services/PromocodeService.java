package example.PromocodeAPI.services;

import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.database.PromocodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PromocodeService {

    private final PromocodeRepository repository;

    @Autowired
    public PromocodeService(PromocodeRepository repository) {
        this.repository = repository;
    }

    public List<Promocode> findAllPromocodes() {
        return repository.findAllPromocodes();
    }

    public String createPromocode(Promocode promocode) {
        System.out.println("Создаем промокод: " + promocode.getCode());
        System.out.println("Скидка: " + promocode.getDiscount() + "%");
        System.out.println("Описание: " + promocode.getDescription());
        System.out.println("Бизнес: " + promocode.getBusinessEmail());

        repository.savePromocode(promocode);

        return "Промокод " + promocode.getCode() + " создан!";
    }

    public void deletePromocode(Long promocodeId) {
        repository.deletePromocode(promocodeId);
    }
}
