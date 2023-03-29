package kg.mega.natv_final.mappers;

import kg.mega.natv_final.models.dto.crud.OrderDto;
import kg.mega.natv_final.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDto orderDto);

}
