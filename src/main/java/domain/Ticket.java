package domain;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;
    private String place;
    private boolean acheter;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    @JsonBackReference
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "acheteur_id")
    private Utilisateur acheteur;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isAcheter() {
        return acheter;
    }

    public void setAcheter(boolean acheter) {
        this.acheter = acheter;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Utilisateur getAcheteur() {
        return acheteur;
    }
    public void setAcheteur(Utilisateur acheteur) {
        this.acheteur = acheteur;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", prix=" + prix +
                '}';
    }

}




