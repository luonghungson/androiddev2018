package com.example.hungson.twitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

public class NewTweetActivity extends AppCompatActivity {
    private static final String TAG = "NewTweetActivity";
    public EditText Tweet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tweet);

        Tweet=(EditText) findViewById(R.id.edit_text);
    }
    @Override
    protected void onStart () {
        super.onStart();
        Log.i(TAG, "onStart");
    }
    @Override
    protected void onResume () {
        super.onResume();
        Log.i(TAG, "onResume");
    }
    @Override
    protected void  onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
    @Override
    protected void onStop () {
        super.onStop();
        Log.i(TAG, "onStop");
    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
