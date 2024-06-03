package ee.tlu.eksam;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Sportlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eesnimi;
    private String perenimi;
    private String sugu;
    private String vanusegrupp;

}
