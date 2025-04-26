
import java.util.HashSet;
import java.util.Set;

import rest.EvenementResource;
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
//        clazzes.add(AcceptHeaderOpenApiResource.class);


        return clazzes;
    }

}
