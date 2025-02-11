package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")  // Ajout du nom explicite de la table
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécification de la stratégie
    private Long id;

    @Column(nullable = false)  // Nom obligatoire
    private String nom;

    @Column(nullable = false)  // Prénom obligatoire
    private String prenom;

    @Column(nullable = false)  // Mot de passe obligatoire
    private String motdepasse;

    @Column(nullable = false, unique = true)  // Email obligatoire et unique
    private String email;

    @OneToMany(mappedBy = "acheteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    public Utilisateur() {}

    public Utilisateur(String nom, String prenom ,String email, String motdepasse) {
        this.nom = nom;
        this.email = email;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
