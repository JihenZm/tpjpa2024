package dto;

import domain.Utilisateur;

public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;

    public UtilisateurDTO() {} // <-- Needed by Jackson

    public UtilisateurDTO(Utilisateur utilisateur){
        this.id = utilisateur.getId();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.email = utilisateur.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }
}
