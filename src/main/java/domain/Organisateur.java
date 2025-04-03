package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisateur") // Ajout du nom explicite de la table
public class Organisateur extends Utilisateur {


    public Organisateur() {}

    public Organisateur(String nom,  String prenom,String email, String motdepasse) {
        super(nom, prenom, email, motdepasse);
    }

}
