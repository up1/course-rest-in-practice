package api.rest;


import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.Map;

@ApplicationPath("")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("api.rest");
    }
}
