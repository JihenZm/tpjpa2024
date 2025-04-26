package dao;

import domain.Admin;
import jpa.EntityManagerHelper;

import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AdminDAO {
    public Admin save(Admin a) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(a);
        t.commit();
        return a;
    }

    public Admin delete(Admin a) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(a);
        t.commit();
        return a;
    }

    public List<Admin> getAllAdmins() {
        String query = "SELECT a FROM Admin a";
        return EntityManagerHelper.getEntityManager().createQuery(query, Admin.class).getResultList();
    }
}
