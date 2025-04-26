package dao;

import jakarta.persistence.*;
import java.util.List;
import domain.Ticket;

public class TicketDAO {
    private EntityManager entityManager;

    public TicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Get available tickets for a given event
    public List<Ticket> getAvailableTickets(Long evenementId) {
        return entityManager.createQuery("SELECT t FROM Ticket t WHERE t.evenement.id = :eventId AND t.acheter = false", Ticket.class)
                .setParameter("eventId", evenementId)
                .getResultList();
    }
}
