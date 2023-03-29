package kg.mega.natv_final.models.dto.responses.response1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountListDto {
    double fromDayCount;
    double discount;
}