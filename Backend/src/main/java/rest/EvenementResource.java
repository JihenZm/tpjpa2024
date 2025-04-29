package rest;

import dao.EvenementDAO;
import domain.Evenement;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jpa.EntityManagerHelper;
import java.util.List;

@Path("/evenements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {

    private EvenementDAO evenementDAO = new EvenementDAO(EntityManagerHelper.getEntityManager());

    @GET
    @Path("/search")
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
        } else {
            throw new WebApplicationException("Bad Request: you must provide a search parameter", 400);
        }
    }
}
