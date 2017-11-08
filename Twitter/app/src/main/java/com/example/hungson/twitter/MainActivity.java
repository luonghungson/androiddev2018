package com.example.hungson.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
//    Button play;
//    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        int[] imageResId ={R.drawable.ic_action_home, R.drawable.ic_action_search,
                R.drawable.ic_action_noti, R.drawable.ic_action_mess,
                R.drawable.ic_action_menu};
        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }

//        play =(Button) findViewById(R.id.button2);
//        video =(VideoView) findViewById(R.id.feed3_video);
    }

//    public void playVideo(View v){
//        String videopath = "android.resource://com.example.hungson.twitter/" + R.raw.sapa;
//        Uri uri = Uri.parse(videopath);
//        video.setVideoURI(uri);
//        video.start();
//    }

    public void openNewTweet(View v)
    {
        Intent n = new Intent(this,NewTweetActivity.class);
        startActivity(n);
    }

    public void openProfile(View v)
    {
        Intent n = new Intent(this,ProfileActivity.class);
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

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 5;
//        private String titles[] = new String[] { "News" , "Search" , "Notify" , "Message" , "Info"};

        public HomeFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount(){
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int page){
            switch (page){
                case 0: return new NewsFragment();
                case 1: return new SearchFragment();
                case 2: return new NotifyFragment();
                case 3: return new MessageFragment();
                case 4: return new UserInfoFragment();
            }
            return new EmptyFragment();
        }

//        @Override
//        public CharSequence getPageTitle(int position){
//            return titles[position];
//        }

    }

}