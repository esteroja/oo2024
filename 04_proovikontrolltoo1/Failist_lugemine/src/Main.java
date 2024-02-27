import java.io.BufferedReader;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt")); //java sisseehitatud klass, võib ise nimetada
        String rida = br.readLine();
        while (rida != null) {
            System.out.println(rida);
            String[] sonad = rida.split(" "); //kandiliste sulgude massiivi ei saa addida asju, vaid ainult lugeda --> array; <> --> List
            //@4c86677 <-- kui tekib konsooli, siis see on mälukoht
            System.out.println(Arrays.toString(sonad));
            System.out.println("Rida läbi");

            double ruutu = Math.pow(sonad.length, 2);
            System.out.println(ruutu);

            double ruutjuur = Math.sqrt(sonad.length);
            System.out.println(ruutjuur);

            rida = br.readLine();
        }

    }
}