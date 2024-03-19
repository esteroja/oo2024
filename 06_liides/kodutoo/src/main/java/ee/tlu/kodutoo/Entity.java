package ee.tlu.kodutoo;

import lombok.Getter;

@Getter
public class Entity {
    String nimi;
    int vanus;
    String sugu;

    public Entity(String nimi, int vanus, String sugu) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.sugu = sugu;
    }
}
