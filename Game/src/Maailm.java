import java.util.List;

public class Maailm {

    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(List<Tegelane> tegelased, List<Ese> esemed) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) { //kokku käib suur tsükkel + väike tsükkel 50 korda
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Ese e : esemed) { //käib tsüklit läbi nii kaia kuni listis on objekte, peab tüübi ka ette panema. e on ns objekt arrays
                        if (e.xCoord == x && e.yCoord == y) {
                            symbol = e.symbol;
                        }
                    }
                    for (Tegelane t : tegelased) {
                        if (t.xCoord == x && t.yCoord == y) {
                            symbol = t.symbol;
                        }
                    }

                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    } //void tähendab et funktsioon ei returni midagi
    //vastu võttes on vaja kirj andmetüüp ka ette
}
