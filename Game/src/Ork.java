import java.util.Random;

public class Ork {

    int xCoord; // deklareerin muutuja (loon + mälukoht)
    int yCoord;
    char symbol;

    public Ork(Random random, int kaardiLaius, int kaardiKorgus) {
        xCoord = saaKoordinaat(random, kaardiLaius); //initsialiseerin
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'O';
    }
    private int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }

}
