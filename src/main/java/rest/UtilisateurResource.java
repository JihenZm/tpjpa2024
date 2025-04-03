package rest;

import dao.UtilisateurDAO;
import domain.Utilisateur;
import jpa.EntityManagerHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("utilisateur")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

    private final EntityManager entityManager = EntityManagerHelper.getEntityManager();
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @GET
    @Path("/{id}")
    public Utilisateur getUtilisateurById(@PathParam("id") Long id) {
        return entityManager.find(Utilisateur.class, id);
    }

    @GET
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDAO.getAllUtilisateurs();
    }

    @POST
    public Response addUtilisateur(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
        return Response.ok().entity("Utilisateur ajouté avec succès").build();
    }
}