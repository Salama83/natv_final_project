package kg.mega.natv_final.models.dto.crud;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.natv_final.enums.Status;
import kg.mega.natv_final.models.entities.BannerAdd;
import kg.mega.natv_final.models.entities.Channel;
import kg.mega.natv_final.models.entities.Text;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;

    @JsonFormat(pattern = "dd.MM.yyyy")
    Date createdDate;
    String clientEmail;
    String clientFIO;

    String clientPhone;
    Status orderStatus;

    double orderSum;

    Channel channel;
    Text text_;

    BannerAdd banner_add;
}
