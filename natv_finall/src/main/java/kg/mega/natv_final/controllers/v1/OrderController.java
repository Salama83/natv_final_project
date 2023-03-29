package kg.mega.natv_final.controllers.v1;

import io.swagger.annotations.ApiOperation;
import kg.mega.natv_final.models.dto.crud.OrderDto;
import kg.mega.natv_final.models.dto.requests.request3.OrderReqDto;
import kg.mega.natv_final.models.dto.responses.response3.OrderResDto;
import kg.mega.natv_final.models.entities.Order;
import kg.mega.natv_final.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @ApiOperation("Сохранение заказов")
    @PostMapping("/crud/save")
    public OrderDto crudSave(@RequestBody OrderDto orderDto){
        return orderService.crudSave(orderDto);
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }
    @ApiOperation("Создание заявки на рекламу")
    @PostMapping("/save")
    public OrderResDto save(@RequestBody OrderReqDto orderReqDto){
        return orderService.save(orderReqDto);
    }

}
