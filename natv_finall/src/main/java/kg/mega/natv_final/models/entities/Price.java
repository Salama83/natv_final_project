package kg.mega.natv_final.models.entities;

import jakarta.persistence.*;
import kg.mega.natv_final.utils.DateUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double pricePerSymbol;
    double bannerPrice;
    Date startDate;
    Date endDate;
    @ManyToOne
    Channel channel;
    @PrePersist
    void startEndDate() {
        startDate = new Date();
        endDate = new DateUtil().getInstance().getEndDate();
    }
}
