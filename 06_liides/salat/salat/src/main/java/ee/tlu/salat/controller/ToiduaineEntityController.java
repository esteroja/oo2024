package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduaineEntity;
import ee.tlu.salat.repository.ToiduaineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // kontroller EHK front-end saab siit ligi
@RequestMapping("/api") // saan igale Api otspunktile eesliidese panna
@CrossOrigin(origins = "http://localhost:3000") //see ütleb, mis rakendus mulle ligi päase

public class ToiduaineEntityController {
    // ["kartul", "vorst"];
    // [{nimi: "Lartul, valk:0}]

    // 2) variant - tavaline kosntruktor
    ToiduaineRepository toiduaineRepository; // ühendan Repository, et saaks ligi andmebaasi päringutele
    // imitatsioon: ToiduaineRepository toiduaineRepository = new ToiduaineRepository();

    //Dependency Injection -- tõmbame mingi teise klassi(interface) + ei toimi kogu aeg new tegemist

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

    //muutmine (putmapping asemel) tuleb teha et frontend aru saaks
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity){
        if (toiduaineEntity.getValk() + toiduaineEntity.getRasv() + toiduaineEntity.getSysivesik() > 100){ //getValk jne on läbi getteri/toiduaine entityst
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

/*    @GetMapping("toiduained")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk){
        List<ToiduaineEntity> toiduained = toiduaineRepository.findAll();
        List<ToiduaineEntity> tingimuseleVastavadToiduained = new ArrayList<>();
        for (ToiduaineEntity t: toiduained){
            if (t.valk >= minValk){
                tingimuseleVastavadToiduained.add(t);
            }
        }
        return toiduaineRepository.findAll();
    }*/ // SELECT * FROM Toiduained WHERE valk >=5;


    //findAll on funktsionaalsus, mis küsib kõik andmed andmebaasist

    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk){
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }

    @GetMapping("toiduained-sysivesik-min/{min}/{max}")
    public List<ToiduaineEntity> toiduainedSysivesik(@PathVariable int min, @PathVariable int max){
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }

}

//Kodus: teha uus projekt-> samalt lingilt mis githubis, aga tuleb panna uus nimi
//zip fail->pakkida lahti->õigesse kohta
//sarnane projekt, võib teha midagi et numbreid saaks listist kokku lisada
//võib kasutada eelmiste kodutööde entityt


// get delete put - PATHVARIABLE (3)
// get - requestparam (2)
// post put - BODY (1)