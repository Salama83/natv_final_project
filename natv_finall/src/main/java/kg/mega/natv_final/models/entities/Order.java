package kg.mega.natv_final.models.entities;

import jakarta.persistence.*;
import kg.mega.natv_final.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date createdDate = new Date();
    String clientEmail;
    String clientFIO;
    String clientPhone;
    @Enumerated(EnumType.STRING)
    Status orderStatus;
    @ManyToOne
    Channel channel;
    @ManyToOne
    Text textAdd;
    @ManyToOne
    BannerAdd bannerAdd;
    double orderSum;

}
