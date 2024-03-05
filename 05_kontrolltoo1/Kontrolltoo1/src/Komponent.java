public class Komponent {
    int kogus; //grammides
    Toiduaine toiduaine;

    public Komponent(int kogus, Toiduaine toiduaine) {
        this.kogus = kogus;
        this.toiduaine = toiduaine;
    }

    public double arvutaRasvaKogus() {
        return toiduaine.rasvadeprots/100.0 * kogus;
    }
}
