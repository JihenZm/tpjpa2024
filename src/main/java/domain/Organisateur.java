package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisateur") // Ajout du nom explicite de la table
public class Organisateur extends Utilisateur {

    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evenement> evenements = new ArrayList<>();

    public Organisateur() {}

    public Organisateur(String nom, String email, String prenom, String motdepasse) {
        super(nom, email, prenom, motdepasse);
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
