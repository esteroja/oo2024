package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.model.Harrypotter;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")

public class RestTemplateController {

    // https://hp-api.onrender.com/api/characters
    @GetMapping("tegelased")
    public List<Harrypotter> getTegelased(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://hp-api.onrender.com/api/characters";

        ResponseEntity<Harrypotter[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Harrypotter[].class);

        return List.of(response.getBody());
    }

    @GetMapping("tegelased/{house}")
    public List<Harrypotter> getTegelasedByHouse(@PathVariable String house){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://hp-api.onrender.com/api/characters";
        ResponseEntity<Harrypotter[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Harrypotter[].class);

        List<Harrypotter> majad = new ArrayList<>();
        for (Harrypotter h : response.getBody()){
            if (h.getHouse().equals(house)){
                majad.add(h);
            }
        }
        return majad;

    }
}
