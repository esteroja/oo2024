package ee.tlu.kodutoo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<Integer> numbrid = new ArrayList<>();

    public Controller(){
        numbrid.add(1);
        numbrid.add(4);
        numbrid.add(8);
    }

    @GetMapping("numbrid")
    public List<Integer> saaNumbrid(){
        return numbrid;
    }

    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumber(@PathVariable int number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

    @GetMapping("numbrid/mitu")
    public int mituNumbrit(){
        return numbrid.size();
    }

    @GetMapping("numbrid/summa")
    public int numbriteSumma(){
        int summa = 0;
        for (int i: numbrid){
            summa += i;
        }
        return summa;
    }

    @GetMapping("numbrid/keskmine")
    public float numbriteKesk(){
        float summa = 0;
        for (int i: numbrid){
            summa += i;
        }
        return summa / (numbrid.size());
    }


}
