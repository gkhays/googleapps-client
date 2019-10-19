package org.gkh.google.client.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.gkh.google.client.MinimalOAuthProvider;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;

@Path("oauth2")
public class LoginResource {

	@Context
    private UriInfo uriInfo;
	
	@GET
    @Path("authorize")
	public Response login(@QueryParam("code") String code, @QueryParam("state") String state) {
		final OAuth2CodeGrantFlow flow = MinimalOAuthProvider.getFlow();
		final TokenResult tokenResult = flow.finish(code, state);
		MinimalOAuthProvider.setAccessToken(tokenResult.getAccessToken());
		
		final URI uri = UriBuilder.fromUri(uriInfo.getBaseUri()).path("users").build();
        return Response.seeOther(uri).build();
	}
}
