package ma.ac.ginf.emi.fajouianas.service;

import ma.ac.ginf.emi.fajouianas.entity.Invite;
import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.repo.InviteRepository;
import ma.ac.ginf.emi.fajouianas.repo.MariageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MariageService {
    private final MariageRepository mariageRepository;
    private final InviteRepository inviteRepository;

    public MariageService(MariageRepository mariageRepository, InviteRepository inviteRepository) {
        this.mariageRepository = mariageRepository;
        this.inviteRepository = inviteRepository;
    }

    public List<Mariage> findAll() {
        return mariageRepository.findAll();
    }

    public Mariage findById(Long id) {
        return mariageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("mariage with numero " + id + " was not found"));
    }

    public Mariage addMariage(Mariage mariage) {
        return mariageRepository.save(mariage);
    }

    public Mariage updateMariage(Mariage mariage) {
        if(mariageRepository.findById(mariage.getNumero()) != null)
            return mariageRepository.save(mariage);
        return null;
    }

    public void deleteMariage(Long id) {
        mariageRepository.deleteById(id);
    }

    public Mariage qrinvitation(Long mariageNumero, Invite invite) {
        Mariage mariage = findById(mariageNumero);


        mariage.getInvites().add(invite);
        invite.getMariages().add(mariage);

        inviteRepository.save(invite);
        mariageRepository.save(mariage);

        return mariage;
    }
}
