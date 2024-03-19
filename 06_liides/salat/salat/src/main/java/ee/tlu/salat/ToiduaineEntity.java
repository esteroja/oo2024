package ee.tlu.salat;

// jpa moodulist pärinev. Hibernate - teeb java veebiraamistiku ja andmebaasi vahel suhtlust
// Chatgpt võib pakkuda import.javax.persistance.Table
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // sama, mis generate getter (loob funktsiooni, et neid muutujaid kätte saada ja frontendile saata)
@AllArgsConstructor // sama, mis generate constructor

@Table(name="toiduaine") // sellega muudad tabelinime, muidu automaatselt klassinimi (ToiduaineEntity)
@Entity // andmebaasi panekuks - KOHUSTUSLIK
@NoArgsConstructor // andmebaasi panekuks - KOHUSTUSLIK

public class ToiduaineEntity {
    @Id //primaatvõti. alati unikaalne - kustutamiseks, võtmiseks, muutmiseks
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;

//    public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
//        this.nimetus = nimetus;
//        this.valk = valk;
//        this.rasv = rasv;
//        this.sysivesik = sysivesik;
//    }
}
