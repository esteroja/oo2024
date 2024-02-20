import java.util.Random;

public class Ese {
    String nimetus;
    double tugevus;
    int kasutuskorrad;
    boolean aktiivne;
    int xCoord;
    int yCoord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskorrad, Random random,  Maailm maailm) { //siin reas saadad sisse
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true; //ei pea olema konstruktori sees, sest ta luues on alati aktiivne
        xCoord = saaKoordinaat(random, maailm.kaardiLaius);
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'I';
    }

    public void hit() {
        System.out.println("Lõi vastast!");
    }

    private int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }
}
