package ee.tlu.salat;

// Koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> kartul + omadused ja mitu grammi teda on

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // sama, mis generate constructor ja manuaalselt teha
public class ToiduKomponent {
    ToiduaineEntity toiduaine;
    int kogus;
}
