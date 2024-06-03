package ee.tlu.eksam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KatseController {

    @Autowired
    KatseRepository katseRepository;

    @Autowired
    SportlaneRepository sportlaneRepository;


    @GetMapping("tulemused")
    public List<Katse> getKatsed(){
        return katseRepository.findAll();
    }

    @PostMapping("tulemused")
    public List<Katse> postKatse(@RequestBody Katse katse){
        katseRepository.save(katse);
        return katseRepository.findAll();
    }

    @DeleteMapping("tulemused/{id}")
    public List<Katse> deleteKatse(@PathVariable Long id){
        katseRepository.deleteById(id);
        return katseRepository.findAll();
    }
}
