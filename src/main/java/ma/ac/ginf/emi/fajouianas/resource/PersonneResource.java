package ma.ac.ginf.emi.fajouianas.resource;

import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.entity.Personne;
import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.repo.MariageRepository;
import ma.ac.ginf.emi.fajouianas.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personne")
public class PersonneResource {
    private final PersonneService personneService;
    private final MariageRepository mariageRepository;

    public PersonneResource(PersonneService personneService,
                            MariageRepository mariageRepository) {
        this.personneService = personneService;
        this.mariageRepository = mariageRepository;
    }

    @GetMapping("/all")
    public List<Personne> getAll() {
        List<Personne> personnes = personneService.findAll();
        return personnes;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Personne personne = personneService.findById(id);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Personne add(@RequestBody Personne personne) {
        Personne newPersonne = personneService.addPersonne(personne);
        return newPersonne;
    }

    @PutMapping("/update")
    public Personne update(@RequestBody Personne personne) {
        Personne newPersonne = personneService.updatePersonne(personne);
        return newPersonne;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        personneService.deletePersonne(id);
    }

    @PostMapping("/reserver")
    public Mariage reserver(Long hommeId, Long femmeId, @RequestBody Mariage mariage) {
        Mariage mariageReserver = personneService.reserver(hommeId, femmeId, mariage);
        return mariageReserver;
    }

    @PostMapping("/confirmer")
    public Salle reserver(Long mariageNumero, @RequestBody Salle salle) {
        Salle salleConfirmee = personneService.confirmer(mariageNumero, salle);
        return salleConfirmee;
    }
}
