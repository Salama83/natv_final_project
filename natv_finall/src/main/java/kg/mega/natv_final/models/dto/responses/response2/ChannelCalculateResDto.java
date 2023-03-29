package kg.mega.natv_final.models.dto.responses.response2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelCalculateResDto {
    String text;
    int daysCount;
    Long channelId;
    double price;
    double priceWithDiscount;
}
