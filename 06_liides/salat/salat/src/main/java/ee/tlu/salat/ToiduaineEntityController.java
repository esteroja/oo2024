package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ToiduaineEntityController {
    // ["kartul", "vorst"];
    // [{nimi: "Lartul, valk:0}]
    List<ToiduaineEntity> toiduained = new ArrayList<>(); // hoiustab objekte, mitte aint sõnu

    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduined(){
        return toiduained;
    }

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
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}") //tagastamine frontendile???
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=1&rasv=5&sysivesik=1
    // saab teha vabatahtlikuks mingi annotatsiooniga, nt kui tahad aint nime muuta
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index,
                                                @RequestParam String nimi,
                                                @RequestParam int valk,
                                                @RequestParam int rasv,
                                                @RequestParam int sysivesik){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);
        return toiduained;
    }

    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return toiduained.size();
    }

}

//Kodus: teha uus projekt-> samalt lingilt mis githubis, aga tuleb panna uus nimi
//zip fail->pakkida lahti->õigesse kohta
//sarnane projekt, võib teha midagi et numbreid saaks listist kokku lisada
//võib kasutada eelmiste kodutööde entityt
