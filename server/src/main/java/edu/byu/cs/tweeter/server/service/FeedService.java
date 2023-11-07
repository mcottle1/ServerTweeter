package edu.byu.cs.tweeter.server.service;

import java.util.List;

import edu.byu.cs.tweeter.model.domain.Status;
import edu.byu.cs.tweeter.model.net.request.StatusRequest;
import edu.byu.cs.tweeter.model.net.response.StatusResponse;
import edu.byu.cs.tweeter.util.FakeData;
import edu.byu.cs.tweeter.util.Pair;

public class FeedService {
    public StatusResponse getFeed(StatusRequest request) {
        if(request.getUserAlias() == null) {
            throw new RuntimeException("[Bad Request] Request needs to have a user alias");
        } else if(request.getLimit() <= 0) {
            throw new RuntimeException("[Bad Request] Request needs to have a positive limit");
        }
        Pair<List<Status>, Boolean> pair = getFakeData().getPageOfStatus(request.getLastStatus(), request.getLimit());
        return new StatusResponse(pair.getFirst(), pair.getSecond());
    }

    FakeData getFakeData() {
        return FakeData.getInstance();
    }
}

