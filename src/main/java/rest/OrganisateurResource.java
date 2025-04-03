package rest;

import dao.OrganisateurDAO;
import domain.Organisateur;
import jpa.EntityManagerHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("organisateur")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganisateurResource {

    private final EntityManager entityManager = EntityManagerHelper.getEntityManager();
    private final OrganisateurDAO organisateurDAO = new OrganisateurDAO();

    @POST
    public Response addOrganisateur(Organisateur organisateur) {
        organisateurDAO.save(organisateur);
        return Response.status(Response.Status.CREATED).entity(organisateur).build();
    }

    @GET
    public List<Organisateur> getAllOrganisateurs() {
        return organisateurDAO.getAllOrganisateurs();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganisateur(@PathParam("id") Long id) {
        Organisateur organisateur = entityManager.find(Organisateur.class, id);
        if (organisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Organisateur not found").build();
        }
        organisateurDAO.delete(organisateur);
        return Response.ok().entity("Organisateur deleted successfully").build();
    }
}
