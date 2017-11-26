package com.example.hungson.twitter;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

public class NewTweetActivity extends AppCompatActivity {
    ProgressDialog dlgWait;
    EditText edTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tweet);
        edTweet = (EditText) findViewById(R.id.editText);
    }

    public void postTweet(View v) {
        final TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();

        dlgWait = new ProgressDialog(NewTweetActivity.this);
        dlgWait.setMessage("Sending ...");
        dlgWait.show();

        StatusesService statusesService = TwitterCore.getInstance().getApiClient(session).getStatusesService();
        statusesService.update(edTweet.getText().toString(), null, false, null, null, null, true, false, null)
                .enqueue(new Callback<Tweet>() {
                    @Override
                    public void success(Result<Tweet> tweetResult) {
                        Toast.makeText(NewTweetActivity.this, "Done !", Toast.LENGTH_SHORT).show();
                        edTweet.setText("");
                        dlgWait.dismiss();
                    }

                    public void failure(TwitterException e) {
                        Toast.makeText(NewTweetActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        dlgWait.dismiss();
                    }
                });
    }
}
