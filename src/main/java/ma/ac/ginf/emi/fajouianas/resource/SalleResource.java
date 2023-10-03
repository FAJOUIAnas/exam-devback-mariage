package ma.ac.ginf.emi.fajouianas.resource;

import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.service.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salle")
public class SalleResource {
    private final SalleService salleService;

    public SalleResource(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/all")
    public List<Salle> getAll() {
        List<Salle> salles = salleService.findAll();
        return salles;
    }

    @GetMapping("/find/{id}")
    public Optional<Salle> getById(@PathVariable("id") Long id) {
        Optional<Salle> salle = salleService.findById(id);
        return salle;
    }

    @PostMapping("/add")
    public Salle add(@RequestBody Salle salle) {
        Salle newSalle = salleService.addSalle(salle);
        return newSalle;
    }

    @PutMapping("/update")
    public Salle update(@RequestBody Salle salle) {
        Salle newSalle = salleService.updateSalle(salle);
        return newSalle;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        salleService.deleteSalle(id);
    }
}
