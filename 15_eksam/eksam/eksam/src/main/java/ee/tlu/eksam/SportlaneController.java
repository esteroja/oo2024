package ee.tlu.eksam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SportlaneController {

    @Autowired
    SportlaneRepository sportlaneRepository;

    @Autowired
    KatseRepository katseRepository;

    @GetMapping("sportlased")
    public List<Sportlane> getSportlased(){
        return sportlaneRepository.findAll();
    }

    @PostMapping("sportlased")
    public List<Sportlane> addSportlane(@RequestBody Sportlane sportlane){
        sportlaneRepository.save(sportlane);
        return sportlaneRepository.findAll();

    }

    @DeleteMapping("sportlased/{id}")
    public List<Sportlane> deleteSportlane(@PathVariable Long id){
        sportlaneRepository.deleteById(id);
        katseRepository.deleteBySportlaneId(id);
        return sportlaneRepository.findAll();
    }
}
