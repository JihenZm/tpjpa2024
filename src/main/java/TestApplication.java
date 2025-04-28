
import java.util.HashSet;
import java.util.Set;

import rest.*;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(OpenApiResource.class);
        clazzes.add(EvenementResource.class);
        clazzes.add(OrganisateurResource.class);
        clazzes.add(TicketResource.class);
        clazzes.add(UtilisateurResource.class);
        clazzes.add(AuthenticationResource.class);

//        clazzes.add(AcceptHeaderOpenApiResource.class);


        return clazzes;
    }

}
