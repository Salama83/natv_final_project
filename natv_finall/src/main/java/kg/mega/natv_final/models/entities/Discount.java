package kg.mega.natv_final.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import kg.mega.natv_final.utils.DateUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double discount;
    @CreationTimestamp
    @JsonFormat(pattern = "dd.mm.yyyy")
    Date startDate = new Date();
    @JsonFormat(pattern = "dd.mm.yyyy")
    Date endDate;
    double fromDayCount;
    @ManyToOne
    Channel channel;
    @PrePersist
    void endDate() {
        endDate = new DateUtil().getInstance().getEndDate();
    }
}
