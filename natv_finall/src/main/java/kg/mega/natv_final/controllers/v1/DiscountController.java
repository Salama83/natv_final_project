package kg.mega.natv_final.controllers.v1;

import kg.mega.natv_final.models.dto.crud.DiscountDto;
import kg.mega.natv_final.services.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }
    @PostMapping("/save")
    public DiscountDto save(@RequestBody DiscountDto discountDto){
        return discountService.save(discountDto);
    }
    @GetMapping("/findAll")
    public List<DiscountDto> findAll(){
        return discountService.findAll();
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody List<DiscountDto> discountDtoList){
        return discountService.update(discountDtoList);
    }
}