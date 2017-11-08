package com.example.hungson.twitter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hung son on 29-Oct-17.
 */

public class UPMediaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        Log.i("UserProfilesMedia", "onCreate");

        return inflater.inflate(R.layout.up_media_fragment,container,false);
    }
}
