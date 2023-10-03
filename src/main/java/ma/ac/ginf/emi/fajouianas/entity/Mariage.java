package ma.ac.ginf.emi.fajouianas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mariage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero", nullable = false)
    private Long numero;

    private LocalDate date;
    private int nombreMinimumTemoin;
    private int capaciteMinimal;
    private int nombreMaxInviteEpoux;

    @ManyToOne
    @JoinColumn(name = "personne_epoux_id")
    private Personne personneEpoux;

    @ManyToOne
    @JoinColumn(name = "personne_epouse_id")
    private Personne personneEpouse;

    @ManyToMany
    @JoinTable(name = "mariage_invites",
            joinColumns = @JoinColumn(name = "mariage_numero"),
            inverseJoinColumns = @JoinColumn(name = "invites_id"))
    private List<Invite> invites = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "salle_id")
    @JsonIgnore
    private Salle salle;

    public Mariage(LocalDate date, int nombreMinimumTemoin, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.date = date;
        this.nombreMinimumTemoin = nombreMinimumTemoin;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    public Mariage(int nombreMinimumTemoin, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.nombreMinimumTemoin = nombreMinimumTemoin;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    @Override
    public String toString() {
        return "Mariage{" +
                "numero=" + numero +
                ", date=" + date +
                ", nombreMinimumTemoin=" + nombreMinimumTemoin +
                ", capaciteMinimal=" + capaciteMinimal +
                ", nombreMaxInviteEpoux=" + nombreMaxInviteEpoux +
                ", personneEpoux=" + personneEpoux +
                ", personneEpouse=" + personneEpouse +
                ", invites=" + invites +
                '}';
    }
}
