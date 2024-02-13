import java.util.Random;

public class Draakon {

    int xCoord; // deklareerin muutuja (loon + mälukoht)
    int yCoord;
    char symbol;

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); //initsialiseerin
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'D';
    }
    private int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }

}
