package rest;

import dao.UtilisateurDAO;
import domain.Utilisateur;
import dto.EvenementDTO;
import dto.UtilisateurDTO;
import jpa.EntityManagerHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("utilisateur")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

    private final EntityManager entityManager = EntityManagerHelper.getEntityManager();
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUtilisateurById(@PathParam("id") Long id) {
        Utilisateur utilisateur = entityManager.find(Utilisateur.class, id);
        if (utilisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        UtilisateurDTO dto = new UtilisateurDTO(utilisateur);
        return Response.ok(dto).build();
    }

    @GET
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurDAO.getAllUtilisateurs().stream()
                .map(UtilisateurDTO::new)
                .collect(Collectors.toList());
    }

    @POST
    public Response addUtilisateur(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
        return Response.ok().entity("Utilisateur ajouté avec succès").build();
    }
}