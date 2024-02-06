//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // KODUS: 3 funktsiooni milles on kasutatud vähemalt nelja erinevat tüüpi:
        // String, int, char, long, boolean, double, float, void
        // võib olla nii parameetrina kui ka tagastuses
        // tagastab int   parameetriks double
        // tagastab void
        // tagastab String

        //teha igast funktsioonist 2 erineva sisendiga väljakutset (kokku 6 väljakutset)

        double koguHind1 = arvutaTaksoHind(3);
        System.out.println(koguHind1);
        double koguHind2 = arvutaTaksoHind(2);
        System.out.println(koguHind2);

        String vesi1 = temperatuuriHinnang(4);
        System.out.println(vesi1);
        String vesi2 = temperatuuriHinnang(-3);
        System.out.println(vesi2);

        prindiForTsukkel("Pikk sõna");
        prindiForTsukkel("Lüh");
    }
    private static double arvutaTaksoHind(int tunnid) {
        return 3 + 0.8*tunnid;
    }

    private static String temperatuuriHinnang(double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }

    private static void prindiForTsukkel(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.print(i);

        }
    }
}