package dto;
import domain.Evenement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;



// EvenementDTO.java
public class EvenementDTO {
    public Long id;
    public String titre;

    public String date;
    public String description;
    public String lieu;
    public double prix;
    public int popularite;
    public List<TicketDTO> tickets;

    public EvenementDTO(Evenement evenement) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.id = evenement.getId();
        this.titre = evenement.getTitre();
        this.date = sdf.format(evenement.getDate());
        this.description = evenement.getDescription();
        this.lieu = evenement.getLieu();
        this.prix = evenement.getPrix();
        this.popularite = evenement.getPopularite();
        this.tickets = evenement.getTickets() == null ? new ArrayList<>() :
                evenement.getTickets().stream()
                        .map(TicketDTO::new)
                        .collect(Collectors.toList());

    }
}

// TicketDTO.java


