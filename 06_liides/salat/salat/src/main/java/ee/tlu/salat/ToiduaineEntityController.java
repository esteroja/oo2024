package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ToiduaineEntityController {
    // ["kartul", "vorst"];
    // [{nimi: "Lartul, valk:0}]

    // 2) variant - tavaline kosntruktor
    ToiduaineRepository toiduaineRepository;
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }

    // 1) variant
//    @Autowired
//    ToiduaineRepository toiduaineRepository;

    //List<ToiduaineEntity> toiduained = new ArrayList<>(); // hoiustab objekte, mitte aint sõnu


    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduined(){
        return toiduaineRepository.findAll();
    }
    //findAll on funktsionaalsus, mis küsib kõik andmed andmebaasist

    // localhost:8080/api/toiduained/Vorst/15/5/1
    // PathVariable
    // ON järjekord tähtis
    // võin kogemata sassi ajada, muutes järjekorda ja paneb valesti
    // ma ei saa ühtegi vahele jätta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(@PathVariable String nimi,
                                               @PathVariable int valk,
                                               @PathVariable int rasv,
                                               @PathVariable int sysivesik){
        if (valk + rasv + sysivesik > 100){
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine); //add asemel save
        return toiduaineRepository.findAll();
    }

    //muutmine (putmapping asemel)
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity){
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100){
            return toiduaineRepository.findAll();
        }
        // ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}") //tagastamine frontendile???
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi){
        toiduaineRepository.deleteById(nimi); //remove asemel deleteById
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1 <-- @PathVariable
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=1&rasv=5&sysivesik=1 <-- @RequestParam
    // saab teha vabatahtlikuks mingi annotatsiooniga, nt kui tahad aint nime muuta
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index,
                                                @RequestParam String nimi,
                                                @RequestParam int valk,
                                                @RequestParam int rasv,
                                                @RequestParam int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        //toiduained.set(index, toiduaine);
        toiduaineRepository.save(toiduaine); // täpselt sama, mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvõtmega element andmebaasis. Kui on siis muudab elementi, kui pole siis lisab elemendi
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi){
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return toiduaineRepository.findAll().size();
    }

}

//Kodus: teha uus projekt-> samalt lingilt mis githubis, aga tuleb panna uus nimi
//zip fail->pakkida lahti->õigesse kohta
//sarnane projekt, võib teha midagi et numbreid saaks listist kokku lisada
//võib kasutada eelmiste kodutööde entityt


// get delete put - PATHVARIABLE (3)
// get - requestparam (2)
// post put - BODY (1)