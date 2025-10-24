package example.PromocodeAPI.controllers;

import java.util.List;
import java.util.Optional;

import example.PromocodeAPI.models.Promocode;
import example.PromocodeAPI.services.PromocodeService;
import example.PromocodeAPI.database.PromocodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String createPromocode(@RequestBody Promocode promocode) {
        return promocodeService.createPromocode(promocode);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePromocode (@RequestParam("PromocodeId") Long PromocodeId) {
        promocodeService.deletePromocode(PromocodeId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{PromocodeId}")
    public Promocode getPromocodeById(@PathVariable Long PromocodeId) {
        return promocodeService.getPromocodeById(PromocodeId)
                .orElse(null);
    }

}
