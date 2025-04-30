package dao;

import domain.Ticket;
import jakarta.persistence.*;
import java.util.List;
import domain.Evenement;

public class EvenementDAO {
    private EntityManager entityManager;

    public EvenementDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Search events by keyword (in description or location)
    public List<Evenement> searchByKeyword(String keyword) {
        return entityManager.createQuery("SELECT e FROM Evenement e WHERE " +
                        "LOWER(e.description) LIKE LOWER(:keyword) OR " +
                        "LOWER(e.lieu) LIKE LOWER(:keyword)", Evenement.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    // Search events by price range
    public List<Evenement> searchByPriceRange(double minPrice, double maxPrice) {
        return entityManager.createQuery("SELECT e FROM Evenement e WHERE e.prix BETWEEN :min AND :max", Evenement.class)
                .setParameter("min", minPrice)
                .setParameter("max", maxPrice)
                .getResultList();
    }

    // Search events by minimum popularity
    public List<Evenement> searchByPopularity(int minPopularity) {
        return entityManager.createQuery("SELECT e FROM Evenement e WHERE e.popularite >= :popularity", Evenement.class)
                .setParameter("popularity", minPopularity)
                .getResultList();
    }

    public Evenement delete(Evenement evenement) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(evenement);
        transaction.commit();
        return evenement;
    }

    public List<Evenement> getAll() {
        return entityManager.createQuery("SELECT e FROM Evenement e", Evenement.class)
                .getResultList();
    }

}
