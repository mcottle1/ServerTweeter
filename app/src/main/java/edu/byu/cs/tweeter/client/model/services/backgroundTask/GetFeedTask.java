package edu.byu.cs.tweeter.client.model.services.backgroundTask;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import edu.byu.cs.tweeter.client.model.net.ServerFacade;
import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.model.domain.Status;
import edu.byu.cs.tweeter.model.domain.User;
import edu.byu.cs.tweeter.model.net.TweeterRemoteException;
import edu.byu.cs.tweeter.model.net.request.FollowingRequest;
import edu.byu.cs.tweeter.model.net.request.StatusRequest;
import edu.byu.cs.tweeter.model.net.response.FollowingResponse;
import edu.byu.cs.tweeter.model.net.response.StatusResponse;
import edu.byu.cs.tweeter.util.Pair;
import kotlin.Triple;

/**
 * Background task that retrieves a page of statuses from a user's feed.
 */
public class GetFeedTask extends PagedStatusTask {
    private static final String LOG_TAG = "GetFeedTask";
    private ServerFacade serverFacade;

    public GetFeedTask(AuthToken authToken, User targetUser, int limit, Status lastStatus,
                       Handler messageHandler) {
        super(authToken, targetUser, limit, lastStatus, messageHandler);
    }

    @Override
    protected void setUp() {
//        try {
//            String targetUserAlias = getTargetUser() == null ? null : getTargetUser().getAlias();
//            Status lastStatus = getLastItem();
//
//            StatusRequest request = new StatusRequest(authToken, targetUserAlias, limit, lastStatus);
//            StatusResponse response = getServerFacade().getFeed(request, "/getfeed");
//
//            if (response.isSuccess()) {
//                setItems(response.getFeed());
//                setHasMorePages(response.getHasMorePages());
//                sendSuccessMessage();
//            } else {
//                sendFailedMessage(response.getMessage());
//            }
//        } catch (IOException | TweeterRemoteException ex) {
//            Log.e(LOG_TAG, "Failed to get feed", ex);
//            sendExceptionMessage(ex);
//        }
    }
    ServerFacade getServerFacade() {
        if(serverFacade == null) {
            serverFacade = new ServerFacade();
        }
        return serverFacade;
    }
}