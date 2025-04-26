import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("event_pu");
        EntityManager em = emf.createEntityManager();


        EvenementDAO evenementDAO = new EvenementDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);

        // Ajouter un utilisateur



        // Search for events
        List<Evenement> events = evenementDAO.searchByKeyword("concert");
        System.out.println("Events found: " + events.size());

        // Search for available tickets for a specific event
        if (!events.isEmpty()) {
            Long eventId = events.get(0).getId();
            List<Ticket> availableTickets = ticketDAO.getAvailableTickets(eventId);
            System.out.println("Available tickets: " + availableTickets.size());
        }

        em.close();
        emf.close();
    }

