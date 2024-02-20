//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Kasutaja kasutaja = new Kasutaja("M", true, 21, 'x', 0.0);
        Kasutaja kasutaja2 = new Kasutaja("S", false, 41, 'z', 2.5);

        kasutaja.muudaAktiivne();
        System.out.println(kasutaja.aktiivne);
        double kasutaja2raha = kasutaja2.lisaRaha(500.0);
        System.out.println(kasutaja2raha);

        Tellija tellija1 = new Tellija("M", 199.0, "Coca");
        Tellija tellija2 = new Tellija("O", 89.0, "Fanta");

        double dollarites = tellija1.tellimuseSummaDollarites();
        System.out.println(dollarites);

        tellija2.tellijaNimeVahetus("U");
        System.out.println(tellija2.tellija);
    }
}

//Main class + enda tehtud class
//classis konstruktor
//vähemalt 2 omandust
//vähemalt 2 funktsiooni
// väh 2 instantsi temast
//mainis väh 2 funktsiooni väljakutset
//vähemalt 2 sout