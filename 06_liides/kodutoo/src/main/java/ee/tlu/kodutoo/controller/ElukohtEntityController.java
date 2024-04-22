package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.ElukohtEntity;
import ee.tlu.kodutoo.repository.ElukohtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ElukohtEntityController {
    @Autowired
    ElukohtRepository elukohtRepository;

    @GetMapping("veelandmeid")
    public List<ElukohtEntity> saaVeelandmeid() {return elukohtRepository.findAll();}

    @DeleteMapping("veelandmeid/{id}")
    public List<ElukohtEntity> kustutaLinn(@PathVariable Long id){
        elukohtRepository.deleteById(id);
        return elukohtRepository.findAll();
    }

    @PostMapping("veelandmeid")
    public List<ElukohtEntity> lisaVeelanmdeid(@RequestBody ElukohtEntity elukohtEntity){
        elukohtRepository.save(elukohtEntity);
        return elukohtRepository.findAll();
    }

}
