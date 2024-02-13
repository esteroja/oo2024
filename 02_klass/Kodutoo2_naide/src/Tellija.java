public class Tellija {
    String tellija;
    double kogusumma;
    String tellitavEse;

    public Tellija(String _tellija, double _kogusumma, String _tellitavEse) {
        tellija = _tellija;
        kogusumma = _kogusumma;
        tellitavEse = _tellitavEse;
    }

    public double tellimuseSummaDollarites() {
        return kogusumma * 1.07;
    }

    public void tellijaNimeVahetus(String tellijaUusNimi) {
        tellija = tellijaUusNimi;
    }
}
