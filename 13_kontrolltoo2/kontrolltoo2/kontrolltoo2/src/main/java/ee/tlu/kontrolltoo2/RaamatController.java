package ee.tlu.kontrolltoo2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RaamatController {

    @Autowired
    RaamatRepository raamatRepository;
    @Autowired
    private NovellRepository novellRepository;

    @GetMapping("raamatud")
    public List<Raamat> getRaamatud(){return raamatRepository.findAll();}


    @GetMapping("raamatud/{nimetus}")
    public List<Novell> getRaamatuNovellid(@PathVariable String nimetus){
        return novellRepository.findByRaamat_nimetus(nimetus);
    }

    @GetMapping("raamatud-maksumus")
    public double sumRaamatud(){
        double sum = 0;
        for (Raamat r : raamatRepository.findAll()){
            sum += r.getMaksumus();
        }
        return sum;
    }

    @GetMapping("raamatud-maksumus/{kordaja}")
    public double sumRaamatud(@PathVariable double kordaja){
        double sum = 0;
        for (Raamat r : raamatRepository.findAll()){
            sum += r.getMaksumus() * kordaja;
        }
        return sum;
    }

    @GetMapping("raamatud-suurim")
    public Raamat suurimLkArv(@PathVariable int lk){
        return raamatRepository.findFirstByLkOrderByLkDesc(lk);
    }


}

