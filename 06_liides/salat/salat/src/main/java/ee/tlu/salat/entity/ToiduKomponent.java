package ee.tlu.salat.entity;

// Koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> kartul + omadused ja mitu grammi teda on

import ee.tlu.salat.entity.ToiduaineEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor // sama, mis generate constructor ja manuaalselt teha
@NoArgsConstructor //vaja, kui teha andmebaasi konstruktoriks
@Entity
//need kõik kohustuslikud, kui teha andmebaasi komponendiks (klassikomplekt)

public class ToiduKomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)//annotatsioon, et see on andmebaas ;
    // kui kustutatakse toiduaine, siis kustutatakse temaga seotud toidukomponendid (cascade)
    ToiduaineEntity toiduaine; // kui see oleks list, siis tuleks panna @ManyToMany

    //£ManyToMany
    //List<ToiduaineEntity> toiduained;
    int kogus;

    // {id: 5, toiduaine: {nimetus: "Vorst", kogus: 100}
    // 5     |     "Vorst"   |   100
}
