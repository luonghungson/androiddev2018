package com.example.hungson.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "onCreate");

    }

    public void openMainActivity(View v)
    {
        Intent n = new Intent(this,MainActivity.class);
        startActivity(n);
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
