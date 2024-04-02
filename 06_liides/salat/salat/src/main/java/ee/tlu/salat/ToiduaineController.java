package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // annotatsioon
@CrossOrigin(origins = "http://localhost:3000")
// @CrossOrigin(origins = "*") -- kõik

public class ToiduaineController {
    List<String> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhtoiduained ---> saab listi kõikidest toiduainetest []
    @GetMapping("toiduained")
    public List<String> saaToiduined(){
        return toiduained;
    }

    // PostMappingut ei saa brauser teha, pole brauseri omadus. brauser saab aint gettida
    // localhost:8080/toiduained/Kartul POST --> saab vaadata aint postmanis
    @PostMapping("toiduained/{toiduaine}") //tagastamine frontendile???
    public List<String> lisaToiduaine(@PathVariable String toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }

    // DeleteMappingut ei saa brauser teha, pole brauseri omadus. brauser saab aint gettida
    // localhost:8080/toiduained/0 DELETE --> saab vaadata aint postmanis
    @DeleteMapping("toiduained/{index}") //tagastamine frontendile???
    public List<String> kustutaToiduaine(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }

    // PutMappingut ei saa brauser teha
    // localhost:8080/toiduained/0/Sink PUT --> saab vaadata aint postmanis
    @PutMapping("toiduained/{index}/{newValue}") //tagastamine frontendile???
    public List<String> muudaToiduaine(@PathVariable int index,
                                       @PathVariable String newValue){
        toiduained.set(index, newValue);
        return toiduained;
    }

    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }

    // CRUD --> Create, Read, Update, Delete
    // GetMapping --> brauseris
    // Postmapping --> mis toimub koodis/andmebaasis






    // localhost:8080/tere
    @GetMapping("tere/{nimi}") // api otspunkt, millega saab frontendi pöörduda
    public String hello(@PathVariable String nimi) { // alati public
        return "Tere " + nimi + "!"; // see väärtus läheb alati frontendi
    }

    // localhost:8080/korruta/1/3
    @GetMapping("korruta/{arv1}/{arv2}") //api otspunkt, tuleb front endi sisse arv1, arv2
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) { //alati public. millegi tegemine?
        return arv1 * arv2; //see väärtus läheb alati frontendi
    }
}

//404 - URL ehk API otspunkt on vale
//4xx - frontendi viga

//5xx - bakcendi viga (serveripoolne viga)