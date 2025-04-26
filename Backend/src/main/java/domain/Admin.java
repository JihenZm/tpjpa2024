package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin") // Ajout du nom explicite de la table
public class Admin extends Utilisateur {

    public Admin() {}

    public Admin(String nom, String prenom ,String email, String motdepasse) {
        super(nom, prenom, email, motdepasse);
    }
}
