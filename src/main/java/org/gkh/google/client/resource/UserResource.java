package org.gkh.google.client.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import javax.servlet.ServletContext;

import org.gkh.google.client.MinimalOAuthProvider;
import org.gkh.google.client.entity.UserBean;
import org.gkh.google.client.entity.UserListBean;
import org.gkh.google.client.model.UserListModel;
import org.gkh.google.client.model.UserModel;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;

@Path("users")
public class UserResource {

	private static final String GOOGLE_USERS_BASE_URI = "https://www.googleapis.com/admin/directory/v1/users";

    @Context
    private UriInfo uriInfo;
    
    @Context
    private ServletContext servletContext;
    
	@GET
	@Produces("application/json")
	public Response getUsers() {
		if (MinimalOAuthProvider.getClientIdentifier() == null) {
            final URI uri = UriBuilder.fromUri(servletContext.getContextPath())
                    .path("/index.html") //to show "Enter your Client Id and Secret" setup page
                    .build();
            return Response.seeOther(uri).build();
        }
        // check access token
        if (MinimalOAuthProvider.getAccessToken() == null) {
            return googleAuthRedirect();
        }
        // We have already an access token. Query the data from Google API.
        final Client client = MinimalOAuthProvider.getFlow().getAuthorizedClient();
        return getUsersResponse(client);
	}
	
	private Response googleAuthRedirect() {
        final String redirectURI = UriBuilder.fromUri(uriInfo.getBaseUri())
                .path("oauth2/authorize").build().toString();

        final OAuth2CodeGrantFlow flow = OAuth2ClientSupport.googleFlowBuilder(
                MinimalOAuthProvider.getClientIdentifier(),
                redirectURI,
                "https://www.googleapis.com/auth/admin.directory.user")
                .prompt(OAuth2FlowGoogleBuilder.Prompt.CONSENT).build();

        MinimalOAuthProvider.setFlow(flow);

        // start the flow
        final String googleAuthURI = flow.start();

        // redirect user to Google Authorization URI.
        return Response.seeOther(UriBuilder.fromUri(googleAuthURI).build()).build();
    }
	
	private Response getUsersResponse(final Client client) {
        client.register(JacksonFeature.class);
        client.register(new LoggingFeature(Logger.getLogger("example.client.users"), LoggingFeature.Verbosity.PAYLOAD_ANY));

        final WebTarget baseTarget = client.target(GOOGLE_USERS_BASE_URI).queryParam("domain", "accessreview.net");
        final Response response = baseTarget.request().get();

        //final List<UserListModel> listOfUsers;
        UserListBean userList;
        switch (response.getStatus()) {
            case 401: //Response.Status.UNAUTHORIZED
                MinimalOAuthProvider.setAccessToken(null);
                return googleAuthRedirect();
            case 200: // Response.Status.OK
                userList = response.readEntity(UserListBean.class);
                break;
            default:
            	userList = null;
        }

        return Response.ok(userList).build();
    }
	
}
