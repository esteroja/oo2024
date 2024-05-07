package ee.tlu.kontrolltoo2;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
public class RestTemplateController {

    @GetMapping("koik-raamatud")
    public List<Root> getBooks(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response = restTemplate.exchange("https://api.itbook.store/1.0/search/mongodb", HttpMethod.GET, null, Root.class);

        return List.of(response.getBody());

    }

    @GetMapping("koik-raamatude-pealkirjad")
    public List<String> getBookTitles() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response = restTemplate.exchange("https://api.itbook.store/1.0/search/mongodb", HttpMethod.GET, null, Root.class);

        List<String> titles = new ArrayList<>();

        for (Book book : response.getBody().getBooks()) {
            titles.add(book.getTitle());
        }

        return titles;
    }

    @GetMapping("koik-raamatud/{title}")
    public List<Book> getBookByName(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response = restTemplate.exchange(
                "https://api.itbook.store/1.0/search/" + title,
                HttpMethod.GET,
                null,
                Root.class
        );
        return response.getBody().getBooks();
    }

    @GetMapping("koik-raamatud-vanim")
    public Book2 getOldest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";

        Book2[] response = restTemplate.getForObject(url, Book2[].class);

        Book2 oldestBook = null;
        int currentOldestYear = Integer.MAX_VALUE;

        for (Book2 book : response) {
            if (book.getPublication_year() < currentOldestYear) {
                currentOldestYear = book.getPublication_year();
                oldestBook = book;
            }
        }

        return oldestBook;
    }

}
