package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // alati vaja controlleril

public class ToiduKomponentController {

    List<ToiduKomponent> toidukomponendid = new ArrayList<>();

    @PostMapping("toidukomponent")
    public List<ToiduKomponent> lisaToidukomponent(@RequestBody ToiduKomponent komponent){
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }

    @PutMapping("toidukomponent/{index}")
    public List<ToiduKomponent> muudaToidukomponent(@PathVariable int index, @RequestBody ToiduKomponent komponent){
        toidukomponendid.set(index, komponent);
        return toidukomponendid;
    }
}

// kui üks kindel asi mida muudad siis put ja path
// kui mitu siis requestparam
// kui set siis requestbody (????)
