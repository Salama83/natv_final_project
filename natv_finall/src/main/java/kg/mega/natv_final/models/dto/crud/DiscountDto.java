package kg.mega.natv_final.models.dto.crud;

import kg.mega.natv_final.models.entities.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {
    Long id;
    int fromDayCount;
    int discount;
    Channel channel;
}
