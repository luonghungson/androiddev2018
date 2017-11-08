package com.example.hungson.twitter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        PagerAdapter adapter = new ProfileActivity.HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager2);
        pager.setOffscreenPageLimit(4);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab2);
        tabLayout.setupWithViewPager(pager);
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
        private final int PAGE_COUNT = 4;
        private String titles[] = new String[] {"Tweet","Tweets & replies","Media","Likes"};

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
                case 0: return new UPTweetFragment();
                case 1: return new UPRepliesFragment();
                case 2: return new UPMediaFragment();
                case 3: return new UPLikesFragment();
            }
            return new EmptyFragment2();
        }

       @Override
        public CharSequence getPageTitle(int position){
            return titles[position];
        }

    }
}
