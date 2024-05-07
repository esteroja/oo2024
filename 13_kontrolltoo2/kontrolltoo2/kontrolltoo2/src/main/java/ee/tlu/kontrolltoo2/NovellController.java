package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NovellController {

    @Autowired
    NovellRepository novellRepository;

    @GetMapping("novellid")
    public List<Novell> getNovellid() {return novellRepository.findAll();}

    @PostMapping("novellid")
    public List<Novell> postNovell(@RequestBody Novell novell){
        if (novell.getSisu().length() >= 10) {
            novellRepository.save(novell);
        }
        return novellRepository.findAll();
    }

    @DeleteMapping("novellid/{id}")
    public List<Novell> deleteNovell(@PathVariable Long id){
        novellRepository.deleteById(id);
        return novellRepository.findAll();
    }

    @GetMapping("vanim-novell")
    public Novell vanimNovell(@PathVariable int aasta){
        return novellRepository.findFirstByAastaOrderByAastaAsc(aasta);
    }

    @GetMapping("luhim-novell")
    public Novell luhimNovell(@PathVariable Long id) {
        int first = 2147483647;
        String title = "";
        for (Novell n : novellRepository.findAll()){
            if(n.getSisu().length() < first){
                first = n.getSisu().length();
                title = n.getPealkiri();
            }
        }
        return novellRepository.findByPealkiri(title);
    }



}
