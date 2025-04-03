package rest;

import dao.TicketDAO;
import domain.Ticket;
import jpa.EntityManagerHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("ticket")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {

    private final EntityManager entityManager = EntityManagerHelper.getEntityManager();
    private final TicketDAO ticketDAO = new TicketDAO();

    @POST
    public Response addTicket(Ticket ticket) {
        ticketDAO.save(ticket);
        return Response.status(Response.Status.CREATED).entity(ticket).build();
    }

    @GET
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicket(@PathParam("id") Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Ticket not found").build();
        }
        ticketDAO.delete(ticket);
        return Response.ok().entity("Ticket deleted successfully").build();
    }
}
