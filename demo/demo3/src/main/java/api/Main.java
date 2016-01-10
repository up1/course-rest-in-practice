package api;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static final URI BASE_URI = UriBuilder.fromUri("http://localhost/api").port(8080).build();

    protected static SelectorThread startServer() throws IOException {
        final Map<String, String> initParams = new HashMap<String, String>();

        initParams.put("com.sun.jersey.config.property.packages", "api.rest");
        initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        LOG.info("Starting grizzly...");

        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(BASE_URI, initParams);
        return threadSelector;
    }

    public static void main(String[] args) throws IOException {
        SelectorThread threadSelector = startServer();
        LOG.info("Jersey app started with WADL available at {}application.wadl\nHit enter to stop it...", BASE_URI);
        System.in.read();
        threadSelector.stopEndpoint();
    }
}
