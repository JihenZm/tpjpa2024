package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import domain.Evenement;
import java.util.Date;


public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	public void createAndPersistEvent() {
		try {
			Evenement event = new Evenement();
			event.setDate(new Date());
			event.setLieu("Paris");
			event.setDescription("Concert de Jazz");
			event.setPrix(50.0);
			event.setPopularite(100);
			manager.persist(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createAndPersistEvent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}
}
