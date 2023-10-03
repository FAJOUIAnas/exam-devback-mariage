package ma.ac.ginf.emi.fajouianas.service;


import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.entity.Personne;
import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.repo.MariageRepository;
import ma.ac.ginf.emi.fajouianas.repo.PersonneRepository;
import ma.ac.ginf.emi.fajouianas.repo.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;
    private final MariageRepository mariageRepository;
    private final SalleRepository salleRepository;
    private final MariageService mariageService;

    public PersonneService(PersonneRepository personneRepository,
                           MariageRepository mariageRepository,
                           SalleRepository salleRepository, MariageService mariageService) {
        this.personneRepository = personneRepository;
        this.mariageRepository = mariageRepository;
        this.salleRepository = salleRepository;
        this.mariageService = mariageService;
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne findById(Long id) {
        return personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("personne with id " + id + " not found"));
    }

    public Personne addPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public Personne updatePersonne(Personne personne) {
        if(personneRepository.findById(personne.getId()) != null)
            return personneRepository.save(personne);
        return null;
    }

    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }

    public Mariage reserver(Long hommeId, Long femmeId, Mariage mariage) {
        Personne homme = findById(hommeId);
        Personne femme = findById(femmeId);

        homme.getMariageEpoux().add(mariage);
        femme.getMariageEpouse().add(mariage);

        mariage.setPersonneEpoux(homme);
        mariage.setPersonneEpouse(femme);

        personneRepository.save(homme);
        personneRepository.save(femme);
        mariageRepository.save(mariage);

        return mariage;
    }

    public Salle confirmer(Long mariageNumero, Salle salle) {
        Mariage mariage = mariageService.findById(mariageNumero);

        if(mariage.getCapaciteMinimal() <= salle.getCapacite()) {
            mariage.setSalle(salle);
            salle.getMariages().add(mariage);

            salleRepository.save(salle);
            mariageRepository.save(mariage);
        }

        return salle;
    }

}
