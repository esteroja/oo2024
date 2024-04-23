package ee.tlu.proovikontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RESOURCES KAUSTAS VAJA MUUTA KA ET ÜHENDADA ANDMEBAASIGA --> COPYPASTE GITHUB
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    @Autowired
    ToodeRepository toodeRepository; //ühendus teise klassiga, et tema seest funktsioone välja kutsuda

    @GetMapping("tooted")
    public List<ToodeEntity> getTooted(){
        return toodeRepository.findAll();
    }

    @PostMapping("tooted")
    public List<ToodeEntity> postToode(@RequestBody ToodeEntity toodeEntity){
        toodeRepository.save(toodeEntity);
        return toodeRepository.findAll();
    }

    @DeleteMapping("tooted/{id}")
    public List<ToodeEntity> deleteToode(@PathVariable Long id){
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<ToodeEntity> tooteHindVahemik(@PathVariable double min, @PathVariable double max){
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public ToodeEntity maxHinnagaToode(){
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc();
    }


}
