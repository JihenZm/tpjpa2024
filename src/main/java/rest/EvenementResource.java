package rest;

import dao.EvenementDAO;
import jpa.EntityManagerHelper;
import domain.Evenement;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("evenement")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {

    private EntityManager entityManager = EntityManagerHelper.getEntityManager();

    private EvenementDAO evenementDAO;

    public EvenementResource() {} // Required for CDI

    @GET
    @Path("/{id}")
    public Evenement getEvenementById(@PathParam("id") Long id) {
        return entityManager.find(Evenement.class, id); // Fix: entityManager should be injected now
    }

    @GET
    public List<Evenement> getAllEvenements() {
        return entityManager.createQuery("SELECT e FROM Evenement e", Evenement.class).getResultList();
    }

    @POST
    public Response addEvenement(Evenement evenement) {
        entityManager.getTransaction().begin();
        entityManager.persist(evenement);
        entityManager.getTransaction().commit();
        return Response.ok().entity("Evenement added successfully").build();
    }
}
