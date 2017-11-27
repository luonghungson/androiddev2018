package com.example.hungson.twitter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.FixedTweetTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;

import static android.content.ContentValues.TAG;

/**
 * Created by hung son on 28-Oct-17.
 */

public class NewsFragment extends Fragment {
    public TweetTimelineRecyclerViewAdapter adapter;
    public RecyclerView recyclerView;
    public FixedTweetTimeline timeline;
    public SwipeRefreshLayout swipeLayout;
    public Result<List<Tweet>> resultlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        Log.i("News_feed", "onCreate");

        final View View = inflater.inflate(R.layout.news_fragment, container, false);
        View.setTag(TAG);


        recyclerView = (RecyclerView) View.findViewById(R.id.recycler_view_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        StatusesService statusesService = twitterApiClient.getStatusesService();



        final Call<List<Tweet>> call = statusesService.homeTimeline(500, null, null, null, null, null, null);
                call.enqueue(new Callback<List<Tweet>>() {
                    @Override
                    public void success(Result<List<Tweet>> result) {
                        resultlist = result;
                        timeline = new FixedTweetTimeline.Builder()
                                .setTweets(resultlist.data)
                                .build();

                        adapter = new TweetTimelineRecyclerViewAdapter.Builder(getActivity())
                                .setTimeline(timeline)
                                .setViewStyle(R.style.tw__TweetDarkWithActionsStyle)
                                .build();
                        recyclerView.setAdapter(adapter);

                        swipeLayout = (SwipeRefreshLayout) View.findViewById(R.id.swipe_refresh_1);
                        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                swipeLayout.setRefreshing(true);
                                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                                    @Override
                                    public void success(Result<TimelineResult<Tweet>> result) {
                                        swipeLayout.setRefreshing(false);
                                    }

                                    @Override
                                    public void failure(TwitterException exception) {

                                    }
                                });
                            }
                        });
//                        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) View.findViewById(R.id.swipe_refresh_1);

//                        timeline = new FixedTweetTimeline.Builder()
//                                .setTweets(result.data)
//                                .build();
//
//                        adapter = new TweetTimelineRecyclerViewAdapter.Builder(getActivity())
//                                .setTimeline(timeline)
//                                .setViewStyle(R.style.tw__TweetDarkWithActionsStyle)
//                                .build();
//                        recyclerView.setAdapter(adapter);

//                        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                            @Override
//                            public void onRefresh() {
//                                swipeLayout.setRefreshing(true);
//                                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
//                                    @Override
//                                    public void success(Result<TimelineResult<Tweet>> result) {
//                                        swipeLayout.setRefreshing(false);
//                                    }
//
//                                    @Override
//                                    public void failure(TwitterException exception) {
//
//                                    }
//                                });
//                            }
//                        });
                    }
                    @Override
                    public void failure(TwitterException exception) {
                    }
                }
        );


        return View;
//        return inflater.inflate(R.layout.news_fragment,container,false);

    }


}