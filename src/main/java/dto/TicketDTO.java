package dto;

import domain.Ticket;

import java.text.SimpleDateFormat;

public class TicketDTO {
    private Long id;
    private double prix;
    private String place;
    private boolean acheter;
    private String dateAchat;
    private Long acheteurId;
    private Long evenementId;

    public TicketDTO() {} // Needed by Jackson

    public TicketDTO(Ticket ticket) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.id = ticket.getId();
        this.acheter = ticket.isAcheter();
        this.prix = ticket.getPrix();
        this.dateAchat = sdf.format(ticket.getDateAchat());
        this.place = ticket.getPlace();
        this.acheteurId = ticket.getAcheteur().getId();
        this.evenementId = ticket.getEvenement().getId();
    }

    public Long getId() {
        return id;
    }

    public double getPrix() {
        return prix;
    }

    public String getPlace() {
        return place;
    }

    public boolean isAcheter() {
        return acheter;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public Long getAcheteurId() {
        return acheteurId;
    }

    public Long getEvenementId() {
        return evenementId;
    }
}
