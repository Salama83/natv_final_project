package kg.mega.natv_final.models.dto.crud;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDatesDto {
    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date days;
    int orderId;
}
