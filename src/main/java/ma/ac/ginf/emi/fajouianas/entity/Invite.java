package ma.ac.ginf.emi.fajouianas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ac.ginf.emi.fajouianas.StatutInvite;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invite extends Personne {
    @Enumerated(EnumType.STRING)
    private StatutInvite statut;

    @ManyToMany(mappedBy = "invites")
    @JsonIgnore
    private List<Mariage> mariages = new ArrayList<>();

    public Invite(String cin, String nom, String prenom, StatutInvite statut) {
        super(cin, nom, prenom);
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "statut=" + statut +
                '}';
    }
}
