import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {

        Toiduaine kartul = new Toiduaine("kartul", 10, 15, 20);
        Toiduaine hapukoor = new Toiduaine("hapukoor", 11, 16, 21);
        Toiduaine vorst = new Toiduaine("vorst", 25, 30, 40);

        Komponent komponent1 = new Komponent(100, kartul);
        Komponent komponent2 = new Komponent(30, hapukoor);
        Komponent komponent3 = new Komponent(50, vorst);

        List<Komponent> komponendid = new ArrayList<>();
        komponendid.add(komponent1);
        komponendid.add(komponent2);
        komponendid.add(komponent3);

        double rasvaProts = komponent1.arvutaRasvaKogus();
        System.out.println("kartulis rasva: " + rasvaProts);

        Toit toit1 = new Toit("kartulisalat", komponendid);

        double valgud = toit1.toiduValkudeKogus();
        System.out.println("valgud: " + valgud);
        double rasvad = toit1.toiduRasvadeKogus();
        System.out.println("rasvad: " + rasvad);
        double susives = toit1.toiduSusivesKogus();
        System.out.println("süsivesikud: " + susives);

        PrintWriter pw = new PrintWriter(new FileWriter("toidud.txt"));
        pw.print(toit1.nimetus + ": ");
        for (Komponent k: komponendid){
            String toiduaine = k.toiduaine.nimetus;
            pw.print(toiduaine);
            pw.print(" - " + k.kogus + " g, ");
        }
        pw.println();
        pw.println("Sisaldab valke " + valgud + " (ühikut), rasvu " + rasvad + " (ühikut), süsivesikuid " + susives + "(ühikut).");
        pw.close();

        BufferedReader br = new BufferedReader(new FileReader("toidud.txt"));
        String rida = br.readLine();

        while (rida != null){
            System.out.println(rida);
            rida = br.readLine();
        }


    }

}

