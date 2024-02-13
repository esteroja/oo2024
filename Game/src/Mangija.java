import java.util.Random;

public class Mangija {

    int xCoord; // deklareerin muutuja (loon + mälukoht)
    int yCoord;
    char symbol;
    Suund suund;

    //konstruktorit kasutavad alati klassid mis pole java
    // alati sama nimetusega mis klass
    // alati public
    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); //initsialiseerin
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'x';
        suund = Suund.YLES;
    } //algväärtuseid on ilus anda ainult konstruktori sees


    public void liigu(String sisend, Maailm maailm) {
        switch (sisend) { //nagu if else, aga ühe muutuja väärtuse võrdlemine teistega
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        } // switchi kinniminek
        switch (suund) {
            case YLES -> {
                if (yCoord > 1) yCoord--;
            }
            case ALLA -> {
                if (yCoord < maailm.kaardiKorgus - 1) yCoord++;
            }
            case VASAKULE -> {
                if (xCoord > 1) xCoord--;
            }
            case PAREMALE -> {
                if (xCoord < maailm.kaardiLaius - 1) xCoord++;
            }
        }
    } //liigu funkts kinniminek

    private int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }
} // mängija kinniminek

//private teeb funktsioone ainult oma klassis
//static - globaalne, main methodis kõik funkts peavad olema static aga klassides ei tohiks olla välja kutsudes
