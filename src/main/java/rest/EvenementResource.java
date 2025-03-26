package rest;

import dao.EvenementDAO;
import domain.Evenement;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("evenement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {
    private EntityManager entityManager;
    private EvenementDAO evenementDAO;

    public EvenementResource(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.evenementDAO = new EvenementDAO(entityManager);
    }

    @GET
    @Path("/{id}")
    public Evenement getEvenementById(@PathParam("id") Long id) {
        return entityManager.find(Evenement.class, id);
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

    @GET
    @Path("search")
    public List<Evenement> searchEvenements(@QueryParam("keyword") String keyword,
                                            @QueryParam("minPrice") Double minPrice,
                                            @QueryParam("maxPrice") Double maxPrice,
                                            @QueryParam("minPopularity") Integer minPopularity) {
        if (keyword != null && !keyword.isEmpty()) {
            return evenementDAO.searchByKeyword(keyword);
        } else if (minPrice != null && maxPrice != null) {
            return evenementDAO.searchByPriceRange(minPrice, maxPrice);
        } else if (minPopularity != null) {
            return evenementDAO.searchByPopularity(minPopularity);
        }
        return getAllEvenements();
    }
}

