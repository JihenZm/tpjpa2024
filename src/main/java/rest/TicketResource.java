package rest;

import dao.TicketDAO;
import domain.Ticket;
import dto.TicketDTO;
import jpa.EntityManagerHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketById(@PathParam("id") Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        TicketDTO dto = new TicketDTO(ticket);
        return Response.ok(dto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketDTO> getAllTickets() {
        return ticketDAO.getAllTickets().stream()
                .map(TicketDTO::new)
                .collect(Collectors.toList());
    }

}
