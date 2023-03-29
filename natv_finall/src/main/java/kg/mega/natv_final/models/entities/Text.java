package kg.mega.natv_final.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_text")
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    int symbolCount;
    private Text(String text, int symbolCount) {
        this.text = text;
        this.symbolCount = symbolCount;
    }
    public static Text prepareString(String text) {
        text = text.replaceAll(" ","");

        return new Text(text,text.length());
    }
}
