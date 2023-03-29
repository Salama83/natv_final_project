package kg.mega.natv_final.models.dto.requests.request2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelCalculateReqDto {
    String text;
    int daysCount;
    Long channelId;
}
