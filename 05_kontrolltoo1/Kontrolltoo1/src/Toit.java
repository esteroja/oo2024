import java.util.List;

public class Toit {
    String nimetus;
    List<Komponent> komponendid;

    public Toit(String nimetus, List<Komponent> komponendid) {
        this.nimetus = nimetus;
        this.komponendid = komponendid;
    }

    public double toiduValkudeKogus() {
        double valgudKokku = 0;
        for (Komponent k: komponendid){
            double valgud = k.toiduaine.valkudeprots/100.0 * k.kogus;
            valgudKokku = valgudKokku + valgud;
        }
        return valgudKokku;
    }

    public double toiduRasvadeKogus() {
        double rasvadKokku = 0;
        for (Komponent k: komponendid){
            double rasvad = k.toiduaine.rasvadeprots/100.0 * k.kogus;
            rasvadKokku = rasvadKokku + rasvad;
        }
        return rasvadKokku;
    }

    public double toiduSusivesKogus(){
        double susivesKokku = 0;
        for (Komponent k: komponendid){
            double susives = k.toiduaine.rasvadeprots/100.0 * k.kogus;
            susivesKokku = susivesKokku + susives;
        }
        return susivesKokku;
    }
}
