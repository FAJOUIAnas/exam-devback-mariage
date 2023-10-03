package ma.ac.ginf.emi.fajouianas.resource;

import ma.ac.ginf.emi.fajouianas.entity.Invite;
import ma.ac.ginf.emi.fajouianas.service.InviteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/invite")
public class InviteResource {
    private final InviteService inviteService;

    public InviteResource(InviteService inviteService) {
        this.inviteService = inviteService;
    }

    @GetMapping("/all")
    public List<Invite> getAll() {
        List<Invite> invites = inviteService.findAll();
        return invites;
    }

    @GetMapping("/find/{id}")
    public Optional<Invite> getById(@PathVariable("id") Long id) {
        Optional<Invite> invite = inviteService.findById(id);
        return invite;
    }

    @PostMapping("/add")
    public Invite add(@RequestBody Invite invite) {
        Invite newInvite = inviteService.addInvite(invite);
        return newInvite;
    }

    @PutMapping("/update")
    public Invite update(@RequestBody Invite invite) {
        Invite newInvite = inviteService.updateInvite(invite);
        return newInvite;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        inviteService.deleteInvite(id);
    }
}
