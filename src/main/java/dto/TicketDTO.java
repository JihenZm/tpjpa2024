package dto;

import domain.Ticket;

public class TicketDTO {
    public Long id;
    public boolean acheter;
    public double prix;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.acheter = ticket.isAcheter();
        this.prix = ticket.getPrix();
    }
}