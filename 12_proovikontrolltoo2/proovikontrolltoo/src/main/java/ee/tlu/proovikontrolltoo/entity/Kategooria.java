package ee.tlu.proovikontrolltoo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Kategooria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;

    // @ManyToMany
    // List<ToodeEntity> tooted;
    // see teeb uue tabeli kus: kategooria id ja toode id koos seotud

//    @ManyToOne --> SEE PEAB OLEMA TOODEeNTITY FAILIS
//    private Kategooria kategooria;
//    //toode tabelis on kategooria tulp ka, kus igale tootele on lisatud kategooria id
}

// vanemate all on lapsed
// tellimuste sees on tooted

// Kategooriate all on tooted
// 1. Kategooriat lisades lisada kõik toooted koos temaga (MANYTOMANY
//2. Kategooriat lisades on tühi array. Eraldi API otspunkt millega saab toodet sisestada (MANYTOMANY)

//3. toofdet lisades lisame ka kategooria(MANY TO ONE)
