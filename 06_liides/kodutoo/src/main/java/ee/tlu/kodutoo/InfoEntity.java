package ee.tlu.kodutoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "andmed")
@Entity
@NoArgsConstructor

public class InfoEntity {
    @Id
    String nimi;
    int vanus;
    String sugu;

}
