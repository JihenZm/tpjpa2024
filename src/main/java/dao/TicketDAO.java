package dao;

import domain.Ticket;
import jpa.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class TicketDAO {
    private final EntityManager entityManager = EntityManagerHelper.getEntityManager();

    public Ticket save(Ticket ticket) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticket);
        transaction.commit();
        return ticket;
    }

    public Ticket delete(Ticket ticket) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(ticket);
        transaction.commit();
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return entityManager.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
    }

    public List<Ticket> getAvailableTickets(Long evenementId) {
        return entityManager.createQuery(
                        "SELECT t FROM Ticket t WHERE t.evenement.id = :eventId AND t.acheter = false", Ticket.class)
                .setParameter("eventId", evenementId)
                .getResultList();
    }
}

