package ee.tlu.kontrolltoo2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Root {
    public String error;
    public String total;
    public String page;
    public ArrayList<Book> books;
}
