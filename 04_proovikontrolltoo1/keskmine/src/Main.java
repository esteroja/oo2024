import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double keskmine = arvutaAritmKesk(4,7,8);
        System.out.println(keskmine);

        List<Double> arvud = new ArrayList<>(); //vaja enne list tekitada kui saad välja kutsuda
        arvud.add(4.0);
        arvud.add(7.0);
        arvud.add(8.0);

        List<Double> libisevadKeskmised = arvutaLibisevKesk(arvud);
        System.out.println(libisevadKeskmised);

        Keskmine keskmine1 = new Keskmine(arvud);
        List<Double> libisevKeskmine1 = keskmine1.saaArvudKesk();
        System.out.println(libisevKeskmine1);
        keskmine1.lisadaArv(10.0);
        List<Double> libisevKeskmine2 = keskmine1.saaArvudKesk();
        System.out.println(libisevKeskmine2);

    }

    //private static --> kui funktsioon kutsutakse mainis
    //public --> kui loon funktsiooni teises klassis
    private static double arvutaAritmKesk(double arv1, double arv2, double arv3){
        return (arv1 + arv2 + arv3) / 3;
    }

    private static List<Double> arvutaLibisevKesk(List<Double> arvud) {
        List<Double> arvudKeskmised = new ArrayList<>();
        for (int i = 0; i < arvud.size()-2; i++) { //fori
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2) ; //arvud[i]
            double libisevKesk = summa / 3;
            arvudKeskmised.add(libisevKesk);

        }
        return arvudKeskmised;
    }
}