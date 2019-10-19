package org.gkh.google.client.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.gkh.google.client.MinimalOAuthProvider;
import org.glassfish.jersey.client.oauth2.ClientIdentifier;

@Path("setup")
public class OAuthClientResource {

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces("text/html")
	public Response setup(@QueryParam("clientId") String key, @QueryParam("clientSecret") String secret) {

		MinimalOAuthProvider.setClientIdentifier(new ClientIdentifier(key, secret));
		final URI uri = UriBuilder.fromUri(uriInfo.getBaseUri()).path("users").build();

		return Response.seeOther(uri).build();
	}

}
