package ma.ac.ginf.emi.fajouianas.service;

import ma.ac.ginf.emi.fajouianas.entity.Invite;
import ma.ac.ginf.emi.fajouianas.entity.Mariage;
import ma.ac.ginf.emi.fajouianas.repo.InviteRepository;
import ma.ac.ginf.emi.fajouianas.repo.MariageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InviteService {
    private final InviteRepository inviteRepository;

    public InviteService(InviteRepository inviteRepository) {
        this.inviteRepository = inviteRepository;
    }

    public List<Invite> findAll() {
        return inviteRepository.findAll();
    }

    public Optional<Invite> findById(Long id) {
        return inviteRepository.findById(id);
    }

    public Invite addInvite(Invite invite) {
        return inviteRepository.save(invite);
    }

    public Invite updateInvite(Invite invite) {
        if(inviteRepository.findById(invite.getId()) != null)
            return inviteRepository.save(invite);
        return null;
    }

    public void deleteInvite(Long id) {
        inviteRepository.deleteById(id);
    }
}
