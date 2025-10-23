package example.PromocodeAPI.controllers;

import java.util.List;
import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.services.PromocodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promocode")
public class PromocodeController {

    @Autowired
    private PromocodeService  promocodeService;

    @GetMapping("/list")
    public List<Promocode> getAllPromocodes() {
        return promocodeService.findAllPromocodes();
    }

}
