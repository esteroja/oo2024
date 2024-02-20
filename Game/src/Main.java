import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //saab enda sisse terve hunniku funktsioone ja muutujaid - klass
        Random random = new Random(); //klassi loomine

        Maailm maailm = new Maailm(5, 10); // instantsi tegemine - NEW
        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mangija);
        tegelased.add(draakon);
        tegelased.add(ork);


        //klassi loomine (Mangija klassi tüüp(nagu int, char jne) e objekt). mangija nimi
        //väärtuse saatmiseks teise klassi tuleb panna need sulgudesse ja tekitada konstruktor klassi failis
        // väärtused peaksid olema ainult ühes kohas kirjutatud välja


        Ese m66k = new Ese("Mõõk", 10, 1, random, maailm);
        Ese haamer = new Ese("Haamer", 5, 3, random, maailm);
        Ese saabas = new Ese("Saabas", 1, 5, random, maailm); // klassikomplekt on omaduste hulk?
        List<Ese> esemed = new ArrayList<>(); //uus klass, saab kõik omadused mis array listi sees. <> ütleb et mis tüüpi(ehk aint m66k, haamer ja saabas sobivad). Listi sobivad aint sama tüüpi asjad
        //List<Integer> taisarvulised;
        //List<String> sonalised;
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);


        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // klass

        maailm.prindiKaart(tegelased, esemed); //asjade saatmine on 0 kulu
        String sisend = scanner.nextLine(); //alati string

        mangija.liigu(sisend, maailm);

        // if (boolean || andmebaasiKüsimine()) - EHK lihtne küsimine vasakul pool ja kulukam/keerukam küsimine paremal
        // if (andmebaasiKüsimine() && boolean) - peaks olema vastupidi

        while (!sisend.equals("end")) { // .equals --> ==    !väärtus.equals --> !=
            maailm.prindiKaart(tegelased, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
            for (Ese e: esemed) {
                if (mangija.xCoord == e.xCoord && mangija.yCoord == e.yCoord) {
                    mangija.ese = e;
                    System.out.println("Korjasid üles eseme: " + e.nimetus);
                    break;
                }
            }
            // JavaScript: esemed.forEach(e => { if (e.xCoord && e.yCoord)})
            // veel üks for tsukkel süiduki jaoks
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