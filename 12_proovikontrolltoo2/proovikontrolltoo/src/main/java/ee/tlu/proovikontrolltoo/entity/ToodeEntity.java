package ee.tlu.proovikontrolltoo.entity;

import ee.tlu.proovikontrolltoo.entity.Kategooria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity //selleks et teeks anmebaasi tabeliks
@NoArgsConstructor //tegelt pole vist allargsi vaja aga võib panna igaksjuhuks???
public class ToodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    private double hind;
    private boolean aktiivne;

    @ManyToOne
    private Kategooria kategooria;

    // {"nimi": "asas",
    // "hind" : 1234,
    // "aktiivne": true,
    // "kategooria": {"id": 2}
}
