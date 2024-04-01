package ee.tlu.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teine")
public class EntityController {
    //@Autowired
            //InfoRepository infoRepository;

    InfoRepository infoRepository;
    public EntityController(InfoRepository infoRepository){
        this.infoRepository = infoRepository;
    }

    //List<InfoEntity> andmed = new ArrayList<>();

    @GetMapping("andmed")
    public List<InfoEntity> saaAndmed(){
        return infoRepository.findAll();
    }

    @PostMapping("andmed/{nimi}/{vanus}/{sugu}")
    public List<InfoEntity> lisaInfo(@PathVariable String nimi,
                                     @PathVariable int vanus,
                                     @PathVariable String sugu){
        if (!sugu.equals("mees") && !sugu.equals("naine")){
            return infoRepository.findAll();
        }
        InfoEntity info = new InfoEntity(nimi, vanus, sugu);
        infoRepository.save(info);
        return infoRepository.findAll();
    }

    @DeleteMapping("andmed/kustuta/{nimi}")
    public List<InfoEntity> kustutaInfo(@PathVariable String nimi){
        infoRepository.deleteById(nimi);
        return infoRepository.findAll();
    }

    // localhost:8080/teine/andmed/muuda?nimi=Mari&vanus=16&sugu=naine
    @PutMapping("andmed/muuda")
    public List<InfoEntity> muudaInfot(@RequestParam String nimi,
                                       @RequestParam int vanus,
                                       @RequestParam String sugu){
        if (!sugu.equals("mees") && !sugu.equals("naine")){
            return infoRepository.findAll();
        }
        InfoEntity info = new InfoEntity(nimi, vanus, sugu);
        infoRepository.save(info);
        return infoRepository.findAll();
    }

    @GetMapping("andmed/vanustesumma")
    public int vanusteSumma(){
        int summa = 0;
        for (InfoEntity i: infoRepository.findAll()){
            summa += i.vanus;
        }
        return summa;
    }


}
