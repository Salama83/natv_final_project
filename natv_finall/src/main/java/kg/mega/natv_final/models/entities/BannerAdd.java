package kg.mega.natv_final.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_banner_add")
public class BannerAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String filePath;

}
