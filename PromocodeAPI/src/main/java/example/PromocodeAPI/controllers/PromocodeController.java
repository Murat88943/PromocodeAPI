package example.PromocodeAPI.controllers;

import java.util.List;
import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.services.PromocodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promocode")
public class PromocodeController {

    @Autowired
    private PromocodeService promocodeService;

    @GetMapping("/list")
    public List<Promocode> getAllPromocodes() {
        return promocodeService.findAllPromocodes();
    }

    @PostMapping("/create")
    public String createPromocode(@RequestBody Promocode promocode) { // Используем модель Promocode вместо PromocodeCreateRequest
        return promocodeService.createPromocode(promocode);
    }
}
