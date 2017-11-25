package com.example.hungson.twitter;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hung son on 24-Nov-17.
 */

public class TwitterApp extends Application{
    private RequestQueue queue;

    @Override
    public void onCreate(){
        super.onCreate();
        queue = Volley.newRequestQueue(this);
    }

    public RequestQueue getQueue(){ return queue;}
}
