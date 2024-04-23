package ee.tlu.proovikontrolltoo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
