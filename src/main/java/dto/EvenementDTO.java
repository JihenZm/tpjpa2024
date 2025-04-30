package dto;
import domain.Evenement;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// EvenementDTO.java
public class EvenementDTO {
    public Long id;
    public String titre;

    public Date date;
    public String description;
    public String lieu;
    public double prix;
    public int popularite;
    public List<TicketDTO> tickets;

    public EvenementDTO(Evenement evenement) {
        this.id = evenement.getId();
        this.titre = evenement.getTitre();
        this.date = evenement.getDate();
        this.description = evenement.getDescription();
        this.lieu = evenement.getLieu();
        this.prix = evenement.getPrix();
        this.popularite = evenement.getPopularite();
        this.tickets = evenement.getTickets().stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
    }
}

// TicketDTO.java


