package ma.ac.ginf.emi.fajouianas;

import ma.ac.ginf.emi.fajouianas.entity.Invite;
import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.entity.Personne;
import ma.ac.ginf.emi.fajouianas.entity.Salle;
import ma.ac.ginf.emi.fajouianas.service.InviteService;
import ma.ac.ginf.emi.fajouianas.service.MariageService;
import ma.ac.ginf.emi.fajouianas.service.PersonneService;
import ma.ac.ginf.emi.fajouianas.service.SalleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FajouiAnasApplication implements CommandLineRunner {

    private final PersonneService personneService;
    private final InviteService inviteService;
    private final MariageService mariageService;
    private final SalleService salleService;

    public FajouiAnasApplication(PersonneService personneService, InviteService inviteService, MariageService mariageService, SalleService salleService) {
        this.personneService = personneService;
        this.inviteService = inviteService;
        this.mariageService = mariageService;
        this.salleService = salleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FajouiAnasApplication.class, args);
    }

    //JE VOUS RECCOMNDE D'UTILISER LES REQUETTES HTTP DANS LE FICHIER TEST/HTTP
    @Override
    public void run(String... args) throws Exception {

        /*personneService.addPersonne(new Personne("FA199027", "FAJOUI", "Anas"));
        personneService.addPersonne(new Personne("MM200199", "IDK", "Meryeme"));

        personneService.reserver(1L, 2L, new Mariage(10, 10, 10));
        personneService.confirmer(1L, new Salle("Anas et Meryeme", "Berkane adresse", "Berkane", 100));

        mariageService.qrinvitation(1L, new Invite("SD283874", "LAAMOUMRI", "Souhail", StatutInvite.TEMOIN));*/

    }
}
