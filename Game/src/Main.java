import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //saab enda sisse terve hunniku funktsioone ja muutujaid - klass
        Random random = new Random(); //klassi loomine

        Maailm maailm = new Maailm(5, 10);
        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius); //klassi loomine (Mangija klassi tüüp(nagu int, char jne) e objekt). mangija nimi
        //väärtuse saatmiseks teise klassi tuleb panna need sulgudesse ja tekitada konstruktor klassi failis
        // väärtused peaksid olema ainult ühes kohas kirjutatud välja
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);


        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // klass

        maailm.prindiKaart(mangija, draakon, ork); //asjade saatmine on 0 kulu
        String sisend = scanner.nextLine(); //alati string

        mangija.liigu(sisend, maailm);

        // if (boolean || andmebaasiKüsimine()) - EHK lihtne küsimine vasakul pool ja kulukam/keerukam küsimine paremal
        // if (andmebaasiKüsimine() && boolean) - peaks olema vastupidi

        while (!sisend.equals("end")) { // .equals --> ==    !väärtus.equals --> !=
            maailm.prindiKaart(mangija, draakon, ork);
            sisend = scanners.nextLine();
            mangija.liigu(sisend, maailm);
        }


    }//main(args[])

    //ctrl+alt+m -> funktsiooni tegemise shortcut


    //private static int saaKoordinaat(Random random, int kaart) { //ctrl+alt+m -> funktsiooni tegemise shortcut
        //return random.nextInt(1, kaart - 1);
    //}
} //main()

//String sona = "suvaline";
//char esitaht = 's';
//int taisarv = 3243424;
//long andmebaasiID = 1353342341;
//byte pilt = 126;
//println - uus rida sout
//souf - printf