package rest;

import dao.AdminDAO;
import domain.Admin;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jpa.EntityManagerHelper;
import java.util.List;

@Path("/admins")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {

    private AdminDAO adminDAO = new AdminDAO();

    @GET
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @POST
    public Admin createAdmin(Admin admin) {
        return adminDAO.save(admin);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAdmin(@PathParam("id") Long id) {
        Admin admin = EntityManagerHelper.getEntityManager().find(Admin.class, id);
        if (admin != null) {
            adminDAO.delete(admin);
        }
    }
}
