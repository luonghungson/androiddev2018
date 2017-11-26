package com.example.hungson.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {

    TwitterLoginButton loginButton;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "onCreate");

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;

                login(session);
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(LoginActivity.this, "Authentication failed!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void login(TwitterSession session) {
        String username = session.getUserName();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
//    public void openMainActivity(View v)
//    {
//        Intent n = new Intent(this,MainActivity.class);
//        startActivity(n);
//    }

//    @Override
//    protected void onStart () {
//        super.onStart();
//        Log.i(TAG, "onStart");
//    }
//    @Override
//    protected void onResume () {
//        super.onResume();
//        Log.i(TAG, "onResume");
//    }
//    @Override
//    protected void  onPause() {
//        super.onPause();
//        Log.i(TAG, "onPause");
//    }
//    @Override
//    protected void onStop () {
//        super.onStop();
//        Log.i(TAG, "onStop");
//    }
//    @Override
//    protected void onDestroy () {
//        super.onDestroy();
//        Log.i(TAG, "onDestroy");
//    }
//}
