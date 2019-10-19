package org.gkh.google.client.resource;

import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

public class App extends ResourceConfig {

	public App() {
		register(LoginResource.class);
		register(UserResource.class);
		register(OAuthClientResource.class);
		
		register(MustacheMvcFeature.class);
        property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/mustache");

        register(new LoggingFeature(Logger.getLogger("example.server"), LoggingFeature.Verbosity.PAYLOAD_ANY));
	}
}
