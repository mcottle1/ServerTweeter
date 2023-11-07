package edu.byu.cs.tweeter.client.model.services;

import edu.byu.cs.tweeter.client.model.services.backgroundTask.BackgroundTaskUtils;
import edu.byu.cs.tweeter.client.model.services.backgroundTask.GetFeedTask;
import edu.byu.cs.tweeter.client.model.services.backgroundTask.GetStoryTask;
import edu.byu.cs.tweeter.client.model.services.backgroundTask.PostStatusTask;
import edu.byu.cs.tweeter.client.model.services.handler.ListHandler;
import edu.byu.cs.tweeter.client.model.services.handler.MessageHandler;
import edu.byu.cs.tweeter.client.presenter.MainPresenter;
import edu.byu.cs.tweeter.client.presenter.PagedPresenter;
import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.model.domain.Status;
import edu.byu.cs.tweeter.model.domain.User;

public class FeedService{

    public void getFeed(AuthToken authToken, User user, int pageSize,
                        Status lastStatus, PagedPresenter.ListObserver observer){
        GetFeedTask getFeedTask = new GetFeedTask(authToken,
                user, pageSize, lastStatus, new ListHandler<Status>(observer));
        BackgroundTaskUtils.runTask(getFeedTask);
    }

    public void getStory(AuthToken authToken, User user, int pageSize,
                         Status lastStatus, PagedPresenter.ListObserver observer){
        GetStoryTask getStoryTask = new GetStoryTask(authToken,
                user, pageSize, lastStatus, new ListHandler<Status>(observer));
        BackgroundTaskUtils.runTask(getStoryTask);
    }

    public void post(AuthToken authToken, Status newStatus, MainPresenter.MessageObserver observer){
        PostStatusTask statusTask = new PostStatusTask(authToken,
                newStatus, new MessageHandler(observer));
        BackgroundTaskUtils.runTask(statusTask);
    }


}
