package com.example.hungson.twitter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import static android.content.ContentValues.TAG;

/**
 * Created by hung son on 28-Oct-17.
 */

public class NewsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        Log.i("News_feed", "onCreate");

        View rootView = inflater.inflate(R.layout.news_fragment, container, false);
        rootView.setTag(TAG);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final UserTimeline userTimeline = new UserTimeline.Builder().screenName("twitterdev").build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(getActivity())
                        .setTimeline(userTimeline)
                        .setViewStyle(R.style.tw__TweetDarkWithActionsStyle)
                        .build();

        recyclerView.setAdapter(adapter);

        return rootView;
//        return inflater.inflate(R.layout.news_fragment,container,false);

    }
}