package edu.byu.cs.tweeter.model.net.request;

import java.util.HashMap;
import java.util.Map;

import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.model.domain.User;

public class GetCountRequest {
    private AuthToken authToken;
    private User targetUser;
    private Map<String, String> headers;

    private GetCountRequest() {}

    public GetCountRequest(AuthToken authToken, User targetUser) {
        this.authToken = authToken;
        this.targetUser = targetUser;
        this.headers = new HashMap<>();
        headers.put("User", targetUser.getAlias());
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
