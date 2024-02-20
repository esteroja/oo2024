import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKoordinaat {
    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); //initsialiseerin
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'O';
    }
    public int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }

}
