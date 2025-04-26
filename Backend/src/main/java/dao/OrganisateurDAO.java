package dao;

import domain.Organisateur;
import jpa.EntityManagerHelper;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class OrganisateurDAO {
    public Organisateur save(Organisateur o) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(o);
        t.commit();
        return o;
    }

    public Organisateur delete(Organisateur o) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(o);
        t.commit();
        return o;
    }

    public List<Organisateur> getAllOrganisateurs() {
        String query = "SELECT o FROM Organisateur o";
        return EntityManagerHelper.getEntityManager().createQuery(query, Organisateur.class).getResultList();
    }
}