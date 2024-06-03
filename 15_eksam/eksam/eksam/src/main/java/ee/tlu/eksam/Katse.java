package ee.tlu.eksam;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Katse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long katse_id;
    private float tulemus;
    private String spordiala;
    private int etapp;
    @ManyToOne(cascade = CascadeType.MERGE)
    Sportlane sportlane;

}
