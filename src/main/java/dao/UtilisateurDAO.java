package dao;
import domain.Utilisateur;

import jpa.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class UtilisateurDAO {
        public Utilisateur save(Utilisateur u) {
            EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
            t.begin();
            EntityManagerHelper.getEntityManager().persist(u);
            t.commit();
            return u;
        }


    public Utilisateur delete(Utilisateur u) {
            EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
            t.begin();
            EntityManagerHelper.getEntityManager().remove(u);
            t.commit();
            return u;
        }

        public List<Utilisateur> getAllUtilisateurs() {
            String query = "SELECT u FROM Utilisateur u";
            return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
        }
}


