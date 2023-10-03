package ma.ac.ginf.emi.fajouianas.repo;

import ma.ac.ginf.emi.fajouianas.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {


}