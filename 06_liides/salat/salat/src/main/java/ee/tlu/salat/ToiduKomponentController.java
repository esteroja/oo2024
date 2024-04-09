package ee.tlu.salat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ToiduKomponentController {

    @Autowired
    ToiduKomponentRepository toiduKomponentRepository;

    // Bean --> automaatselt loodav klass kui rakendus käivitub (new Class();)
    // @Autowired --> samaväärne konstruktoriga, tõmbab Repository siia sisse (et saaks teha put, delete jne andmebaasis)

    // Selleks et saaks andmebaasist päringuid teha (controller tahab päringuid teha)
    // INSERT INTO ToiduKomponent VALUES("")     ---->    repository.save("");
    // DELETE FROM ToiduKomponent WHERE id = 5    ---->    repository.deleteById(5)
    // SELECT * FROM ToiduKomponent    ---->    repository.findAll()

    // http://localhost:8080/toidukomponendid
    @GetMapping("toidukomponendid")
    public List<ToiduKomponent> getToiduKomponents(){
        return toiduKomponentRepository.findAll();
    }

    // PathVariable: http://localhost:8080/toidukomponendid/4 --> kui üks muutuja
    // RequestParam: http://localhost:8080/toidukomponendid?id=4
    @DeleteMapping("toidukomponendid/{id}")
    public List<ToiduKomponent> deleteToiduKomponent(@PathVariable Long id){
        toiduKomponentRepository.deleteById(id);
        return toiduKomponentRepository.findAll();
    }

    @PostMapping("toidukomponendid")
    public List<ToiduKomponent> addToiduKomponent(@RequestBody ToiduKomponent toiduKomponent){
        toiduKomponentRepository.save(toiduKomponent);
        return toiduKomponentRepository.findAll();
    }
}
