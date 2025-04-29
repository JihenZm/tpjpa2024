package rest;

import dao.TicketDAO;
import domain.Ticket;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jpa.EntityManagerHelper;
import java.util.List;

@Path("/tickets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {

    private TicketDAO ticketDAO = new TicketDAO(EntityManagerHelper.getEntityManager());

    @GET
    @Path("/available")
    public List<Ticket> getAvailableTickets(@QueryParam("evenementId") Long evenementId) {
        return ticketDAO.getAvailableTickets(evenementId);
    }
}
