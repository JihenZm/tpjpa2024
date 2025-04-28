package rest;

import dao.AuthRequest;
import dao.RegisterRequest;
import domain.Utilisateur;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.EntityManagerHelper;

import jakarta.persistence.EntityManager;
import java.util.List;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    @POST
    @Path("/login")
    public Response login(AuthRequest request) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            List<Utilisateur> utilisateurs = em.createQuery(
                            "SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motdepasse = :motdepasse", Utilisateur.class)
                    .setParameter("email", request.getEmail())
                    .setParameter("motdepasse", request.getMotdepasse())
                    .getResultList();

            if (utilisateurs.isEmpty()) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Invalid email or password").build();
            }

            Utilisateur user = utilisateurs.get(0);
            return Response.ok(user).build();

        } catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid email or password").build();
        }
    }

    @POST
    @Path("/register")
    public Response register(RegisterRequest request) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        try {
            // Check if email already exists
            List<Utilisateur> existing = em.createQuery(
                            "SELECT u FROM Utilisateur u WHERE u.email = :email", Utilisateur.class)
                    .setParameter("email", request.getEmail())
                    .getResultList();

            if (!existing.isEmpty()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Email already used").build();
            }

            Utilisateur newUser = new Utilisateur(
                    request.getNom(),
                    request.getPrenom(),
                    request.getEmail(),
                    request.getMotdepasse()
            );

            em.persist(newUser);
            EntityManagerHelper.commit();

            return Response.status(Response.Status.CREATED).entity(newUser).build();

        } catch (Exception e) {
            EntityManagerHelper.rollback();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Registration failed").build();
        }
    }
}
