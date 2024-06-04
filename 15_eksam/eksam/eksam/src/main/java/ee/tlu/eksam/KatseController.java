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


    @GetMapping("tulemused/{spordiala}/{katseid}")
    public float vordlus(@PathVariable String spordiala, @PathVariable Long katseid){
        if (spordiala.equals("kuulitouge")){
            spordiala = "kuulitõuge";
        }
        float suurim = katseRepository.findFirstBySpordialaOrderByTulemusDesc(spordiala).getTulemus();
        float kysitav = katseRepository.findByKatseid(katseid).getTulemus();
        float vordlus = (kysitav * 100) / suurim;
        return vordlus;
    }
}
