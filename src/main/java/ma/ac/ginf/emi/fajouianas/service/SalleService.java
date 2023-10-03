package ma.ac.ginf.emi.fajouianas.service;

import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.repo.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public Optional<Salle> findById(Long id) {
        return salleRepository.findById(id);
    }

    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle updateSalle(Salle salle) {
        if(salleRepository.findById(salle.getId()) != null)
            return salleRepository.save(salle);
        return null;
    }

    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
