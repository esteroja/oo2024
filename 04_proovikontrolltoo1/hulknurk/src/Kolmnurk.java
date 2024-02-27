import java.util.List;

public class Kolmnurk {
    List<Integer> xCoords;
    List<Integer> yCoords; //new arraylisti vaja siis kui ei anna konstruktoris väärtust

    public Kolmnurk(List<Integer> xCoords, List<Integer> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    public int lisaKoordinaadid(int newXCoord, int newYCoord) {
        xCoords.add(newXCoord);
        yCoords.add(newYCoord);

        int summa = 0;
        for (int x: xCoords) {
            summa += x;
        }
        return summa;
    }
}
