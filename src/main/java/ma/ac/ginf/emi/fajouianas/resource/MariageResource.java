package ma.ac.ginf.emi.fajouianas.resource;

import ma.ac.ginf.emi.fajouianas.entity.Invite;
import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.service.MariageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mariage")
public class MariageResource {
    private final MariageService mariageService;

    public MariageResource(MariageService mariageService) {
        this.mariageService = mariageService;
    }

    @GetMapping("/all")
    public List<Mariage> getAll() {
        List<Mariage> mariages = mariageService.findAll();
        return mariages;
    }

    @GetMapping("/find/{id}")
    public Mariage getById(@PathVariable("id") Long id) {
        Mariage mariage = mariageService.findById(id);
        return mariage;
    }

    @PostMapping("/add")
    public Mariage add(@RequestBody Mariage mariage) {
        Mariage newMariage = mariageService.addMariage(mariage);
        return newMariage;
    }

    @PutMapping("/update")
    public Mariage update(@RequestBody Mariage mariage) {
        Mariage newMariage = mariageService.updateMariage(mariage);
        return newMariage;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        mariageService.deleteMariage(id);
    }

    @PostMapping("/qrinvitation")
    public Mariage qrInvitation(Long mariageNumero, @RequestBody Invite invite) {
        Mariage mariage = mariageService.qrinvitation(mariageNumero, invite);
        return mariage;
    }
}
