package rest;

import dao.UtilisateurDAO;
import domain.Utilisateur;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jpa.EntityManagerHelper;
import java.util.List;

@Path("/utilisateurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @GET
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDAO.getAllUtilisateurs();
    }

    @POST
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurDAO.save(utilisateur);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUtilisateur(@PathParam("id") Long id) {
        Utilisateur utilisateur = EntityManagerHelper.getEntityManager().find(Utilisateur.class, id);
        if (utilisateur != null) {
            utilisateurDAO.delete(utilisateur);
        }
    }
}
