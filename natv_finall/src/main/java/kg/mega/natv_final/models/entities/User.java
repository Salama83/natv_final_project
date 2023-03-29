package kg.mega.natv_final.models.entities;

import jakarta.persistence.*;
import kg.mega.natv_final.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fio;
    Role role;
    String login;
    String email;
    String phone;
    Status userStatus;
}
