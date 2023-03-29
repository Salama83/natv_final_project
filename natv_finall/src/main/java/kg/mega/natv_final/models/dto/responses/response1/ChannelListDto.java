package kg.mega.natv_final.models.dto.responses.response1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChannelListDto {
    String channelName;
    @JsonProperty("logo")
    String logoPath;
    @JsonProperty("pricePerLetter")
    double pricePerSymbol;
    List<DiscountListDto> discounts;

}