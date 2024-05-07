package ee.tlu.kontrolltoo2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Novell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pealkiri;
    private String sisu;
    private int aasta;
    @ManyToOne(cascade = CascadeType.ALL)
    Raamat raamat;
}
