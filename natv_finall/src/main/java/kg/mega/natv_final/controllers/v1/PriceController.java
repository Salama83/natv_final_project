package kg.mega.natv_final.controllers.v1;

import io.swagger.annotations.ApiOperation;
import kg.mega.natv_final.models.dto.crud.PriceDto;
import kg.mega.natv_final.models.entities.Price;
import kg.mega.natv_final.services.PriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    @ApiOperation("сохранение цены")
    @PostMapping("/save")
    public PriceDto save(@RequestBody PriceDto priceDto){
        return priceService.save(priceDto);
    }
    @ApiOperation("Найти цену по id")
    @GetMapping("/{id}")
    public Price findById(@PathVariable Long id){
        return priceService.findById(id);
    }
}
