package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teine")
public class EntityController {
    List<Entity> andmed = new ArrayList<>();

    @GetMapping("andmed")
    public List<Entity> saaAndmed(){
        return andmed;
    }

    @PostMapping("andmed/{nimi}/{vanus}/{sugu}")
    public List<Entity> lisaInfo(@PathVariable String nimi,
                                 @PathVariable int vanus,
                                 @PathVariable String sugu){
        if (!sugu.equals("mees") && !sugu.equals("naine")){
            return andmed;
        }
        Entity info = new Entity(nimi, vanus, sugu);
        andmed.add(info);
        return andmed;
    }

    @DeleteMapping("andmed/kustuta/{index}")
    public List<Entity> kustutaInfo(@PathVariable int index){
        andmed.remove(index);
        return andmed;
    }

    // localhost:8080/teine/andmed/muuda?index=0&nimi=Mari&vanus=16&sugu=naine
    @PutMapping("andmed/muuda")
    public List<Entity> muudaInfot(@RequestParam int index,
                                   @RequestParam String nimi,
                                   @RequestParam int vanus,
                                   @RequestParam String sugu){
        if (!sugu.equals("mees") && !sugu.equals("naine")){
            return andmed;
        }
        Entity info = new Entity(nimi, vanus, sugu);
        andmed.set(index, info);
        return andmed;
    }

    @GetMapping("andmed/vanustesumma")
    public int vanusteSumma(){
        int summa = 0;
        for (Entity i: andmed){
            summa += i.vanus;
        }
        return summa;
    }


}
