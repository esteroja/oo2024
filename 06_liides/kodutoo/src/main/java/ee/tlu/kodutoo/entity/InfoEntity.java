package ee.tlu.kodutoo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Getter
@AllArgsConstructor
@Table(name = "andmed")
@Entity
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class InfoEntity {
    @Id
    String nimi;
    int vanus;
    String sugu;

}
