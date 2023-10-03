package ma.ac.ginf.emi.fajouianas.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String adresse;
    private String ville;
    private int capacite;

    @OneToMany(mappedBy = "salle")
    private List<Mariage> mariages = new ArrayList<>();

    public Salle(String nom, String adresse, String ville, int capacite) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", capacite=" + capacite +
                ", mariages=" + mariages +
                '}';
    }
}
