import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> kolmnurk1xCoords = new ArrayList<>();
        kolmnurk1xCoords.add(6);
        kolmnurk1xCoords.add(8);
        kolmnurk1xCoords.add(10);

        List<Integer> kolmnurk1yCoords = new ArrayList<>();
        kolmnurk1yCoords.add(2);
        kolmnurk1yCoords.add(5);
        kolmnurk1yCoords.add(1);

        Kolmnurk kolmnurk = new Kolmnurk(kolmnurk1xCoords, kolmnurk1yCoords);

        System.out.println(kolmnurk.xCoords);
        System.out.println(kolmnurk.yCoords);

        int ymbermoot = kolmnurk.lisaKoordinaadid(5, 10); //selleks et midagi väljastaks ja return oleks kasutusel tuleb panna võrdusmärk ja sellele eelnev osa
        System.out.println(ymbermoot);
    }
}