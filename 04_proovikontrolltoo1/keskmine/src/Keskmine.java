import java.util.ArrayList;
import java.util.List;

public class Keskmine {

    List<Double> arvud = new ArrayList<>(); //eksamplar
    List<Double> arvudKeskmised = new ArrayList<>();

    //Keskmine keskmine = new Keskmine();
    public Keskmine(List<Double> arvudAlguses) {
        arvud = arvudAlguses; // [4,7,8]
        arvutaLibisevKesk(); // [6.3333]
    }

    // vastav käsk
    public void lisadaArv(double arv) {
        double viimane = arvud.get(arvud.size() - 1);
        double eelviimane = arvud.get(arvud.size() - 2);
        double keskmine = (viimane + eelviimane + arv) / 3;
        arvudKeskmised.add(keskmine);

        arvud.add(arv);

    }

    public List<Double> saaArvudKesk(){ //võtab listi ja näitab seda välja
        return arvudKeskmised;
    }

    private List<Double> arvutaLibisevKesk() {
        for (int i = 0; i < arvud.size()-2; i++) { //fori
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2) ; //arvud[i]
            double libisevKesk = summa / 3;
            arvudKeskmised.add(libisevKesk);

        }
        return arvudKeskmised;
    }
}
