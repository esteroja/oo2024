import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int kaardiKorgus = 5;
        int kaardiLaius = 10;

        int mangijaXCoord = saaKoordinaat(random, kaardiLaius); //ctrl+alt+m -> funktsiooni tegemise shortcut
        int mangijaYCoord = saaKoordinaat(random, kaardiKorgus);
        char mangijaSymbol = 'x';

        int draakonXCoord = saaKoordinaat(random, kaardiLaius);
        int draakonYCoord = saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol = 'D';

        int orkXCoord = saaKoordinaat(random, kaardiLaius);
        int orkYCoord = saaKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';

        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitus (objektorienteeritus?)

        prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
        String sisend = scanner.nextLine(); //alati string

        switch (sisend) {
            case "w" -> mangijaYCoord--;
            case "s" -> mangijaYCoord++;
            case "a" -> mangijaXCoord--;
            case "d" -> mangijaXCoord++;
        }

        // if (boolean || andmebaasiKüsimine()) - EHK lihtne küsimine vasakul pool ja kulukam/keerukam küsimine paremal
        // if (andmebaasiKüsimine() && boolean) - peaks olema vastupidi

        while (!sisend.equals("end")) { // .equals --> ==    !väärtus.equals --> !=
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
            sisend = scanner.nextLine();
            switch (sisend) {
                case "w" -> mangijaYCoord--;
                case "s" -> mangijaYCoord++;
                case "a" -> mangijaXCoord--;
                case "d" -> mangijaXCoord++;
            }
        }


    }//main(args[])

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaXCoord, int mangijaYCoord, char mangijaSymbol, int draakonXCoord, int draakonYCoord, char draakonSymbol, int orkXCoord, int orkYCoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) { //kokku käib suur tsükkel + väike tsükkel 50 korda
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangijaXCoord && y == mangijaYCoord) {
                        symbol = mangijaSymbol;
                        //System.out.print(mangijaSymbol);
                    } else if (x == draakonXCoord && y == draakonYCoord) {
                        symbol = draakonSymbol;
                    } else if (x == orkXCoord && y == orkYCoord) {
                        symbol = orkSymbol;
                    } else {
                        symbol = ' ';
                        //System.out.print(' ');
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    } //void tähendab et funktsioon ei returni midagi

    private static int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        return random.nextInt(1, kaart - 1);
    }
} //main()

//String sona = "suvaline";
//char esitaht = 's';
//int taisarv = 3243424;
//long andmebaasiID = 1353342341;
//byte pilt = 126;
//println - uus rida sout
//souf - printf