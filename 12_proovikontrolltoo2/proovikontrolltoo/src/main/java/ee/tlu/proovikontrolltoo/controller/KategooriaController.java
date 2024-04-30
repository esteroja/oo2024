package ee.tlu.proovikontrolltoo.controller;

import ee.tlu.proovikontrolltoo.repository.KategooriaRepository;
import ee.tlu.proovikontrolltoo.repository.ToodeRepository;
import ee.tlu.proovikontrolltoo.entity.Kategooria;
import ee.tlu.proovikontrolltoo.entity.ToodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KategooriaController {

    @Autowired
    KategooriaRepository kategooriaRepository; // saame andmebaasi funktsioone teha
    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("kategooriad")
    public List<Kategooria> getKategooria(){
        return kategooriaRepository.findAll();
    }

    @PostMapping("kategooriad")
    public List<Kategooria> postKategooria(@RequestBody Kategooria kategooria){
        kategooriaRepository.save(kategooria);
        return kategooriaRepository.findAll();
    }

    @DeleteMapping("kategooriad/{id}")
    public List<Kategooria> deleteKategooria(@PathVariable Long id){
        kategooriaRepository.deleteById(id);
        return kategooriaRepository.findAll();
    }

    @GetMapping("kategooria-tooted/{id}")
    public List<ToodeEntity> getKategooriaTooted(@PathVariable Long id){
        return toodeRepository.findByKategooria_Id(id);
    }

    @GetMapping("kategooria-tooted-kokku/{id}")
    public double sumKategooriaTooted(@PathVariable Long id){
//        double sum = 0;
//        for (Toode t : toodeRepository.findByKategooria_Id(id)){
//            sum += t.getHind();
//        }
//        return sum;
        return toodeRepository.findByKategooria_Id(id).stream().mapToDouble(ToodeEntity::getHind).sum();
    }
}
