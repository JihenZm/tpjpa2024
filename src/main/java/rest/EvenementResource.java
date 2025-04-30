package rest;

import dao.EvenementDAO;
import dao.OrganisateurDAO;
import domain.Ticket;
import dto.EvenementDTO;
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
import java.util.stream.Collectors;

@Path("evenement")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {

    private EntityManager entityManager = EntityManagerHelper.getEntityManager();

    private EvenementDAO evenementDAO = new EvenementDAO(entityManager);

    public EvenementResource() {} // Required for CDI

    @GET
    @Path("/{id}")
    public Evenement getEvenementById(@PathParam("id") Long id) {
        return entityManager.find(Evenement.class, id); // Fix: entityManager should be injected now
    }

    @GET
    public List<EvenementDTO> getAllEvenements() {
        List<Evenement> events = evenementDAO.getAll(); // assume you have such a method
        return events.stream()
                .map(EvenementDTO::new)
                .collect(Collectors.toList());
    }

    @POST
    public Response addEvenement(Evenement evenement) {
        entityManager.getTransaction().begin();
        entityManager.persist(evenement);
        entityManager.getTransaction().commit();
        return Response.ok().entity("Evenement added successfully").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvenement(@PathParam("id") Long id) {
        Evenement evenement = entityManager.find(Evenement.class, id);
        if (evenement == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Event not found").build();
        }
        evenementDAO.delete(evenement);
        return Response.ok().entity("Event deleted successfully").build();
    }
}
