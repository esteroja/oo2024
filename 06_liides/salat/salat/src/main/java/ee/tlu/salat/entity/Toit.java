package ee.tlu.salat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity //andmebaasi entiti, kindlalt vaja teha id

public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3,4...
    private Long id;

    private String nimetus;

    @ManyToMany
    List<ToiduKomponent> toidukomponendid;
    // [{"nimi": vorst, kogus: 100}, {"nimi": hapukoor, kogus: 200}]
}

// GenerationType.SEQUENCE --> saan alustada mingist kindlast numbrist ja liikuda mingite kindlate numbrite võrra edasi
// GenerationType.UUID --> acd0923d-56h-4k8m
// GenerationType.AUTO --> automaatselt Postgres enda seadistud
// GenerationType.TABLE -->