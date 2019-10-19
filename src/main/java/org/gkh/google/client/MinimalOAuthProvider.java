package org.gkh.google.client;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;

public class MinimalOAuthProvider {

	private static String accessToken = null;
    /**
     * Contains null or actually authorization flow.
     */
    private static OAuth2CodeGrantFlow flow;
    private static ClientIdentifier clientId;
    
    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
    	MinimalOAuthProvider.accessToken = accessToken;
    }

    public static OAuth2CodeGrantFlow getFlow() {
        return flow;
    }

    public static void setFlow(OAuth2CodeGrantFlow flow) {
    	MinimalOAuthProvider.flow = flow;
    }

    public static ClientIdentifier getClientIdentifier() {
        return clientId;
    }

    public static void setClientIdentifier(ClientIdentifier clientIdentifier) {
    	MinimalOAuthProvider.clientId = clientIdentifier;
    }
    
}
