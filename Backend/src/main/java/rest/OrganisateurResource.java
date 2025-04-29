package rest;

import dao.OrganisateurDAO;
import domain.Organisateur;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jpa.EntityManagerHelper;
import java.util.List;

@Path("/organisateurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganisateurResource {

    private OrganisateurDAO organisateurDAO = new OrganisateurDAO();

    @GET
    public List<Organisateur> getAllOrganisateurs() {
        return organisateurDAO.getAllOrganisateurs();
    }

    @POST
    public Organisateur createOrganisateur(Organisateur organisateur) {
        return organisateurDAO.save(organisateur);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrganisateur(@PathParam("id") Long id) {
        Organisateur organisateur = EntityManagerHelper.getEntityManager().find(Organisateur.class, id);
        if (organisateur != null) {
            organisateurDAO.delete(organisateur);
        }
    }
}
