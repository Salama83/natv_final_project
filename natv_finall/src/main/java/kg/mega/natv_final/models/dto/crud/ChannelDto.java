package kg.mega.natv_final.models.dto.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChannelDto {
    Long channelId;
    String channelName ;
    Date createdDate = new Date();
    @JsonProperty("logo")
    String logoPath;
    boolean channelStatus;
}

