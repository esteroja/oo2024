package ee.tlu.kontrolltoo2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Getter
@NoArgsConstructor
public class Book2 {
    public int id;
    public String title;
    public String author;
    public int publication_year;
    public ArrayList<String> genre;
    public String description;
    public String cover_image;
}
