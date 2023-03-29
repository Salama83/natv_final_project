package kg.mega.natv_final.models.dto.responses.response3;

import kg.mega.natv_final.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResDto {
    String clientEmail;
    String clientFIO;
    String clientPhone;
    String text;
    double totalPrice;
    Status status;
    List<ChannelsListResDto> channels;
}
