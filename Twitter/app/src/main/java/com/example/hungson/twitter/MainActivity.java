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
import android.view.Menu;
import android.view.MenuItem;
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

//        String username = getIntent().getStringExtra("username");
//        TextView uname = findViewById(R.id.TV_username);
//        uname.setText(username);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_refresh:
//                Refresh("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
//
//                return true;

            default:
                Intent i = new Intent(this, PhucActivity.class);
                startActivity(i);
        }
        return true;
    }

//    public void Refresh(String... url) {
//        RequestQueue queue = ((TwitterApp)getApplication()).getQueue();
//        // once, should be performed once per app instance
//        StringRequest request = new StringRequest(url[0],
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            TextView textView = (TextView)findViewById(R.id.feed1_status);
//                            JSONObject obj = new JSONObject(response);
//                            String string = obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("text");
//                            textView.setText(string);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//
//                        }
//                        Log.i("Twitter", "Json response " + response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                    }
//                });
//        queue.add(request);
//    }

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

                default: return new NewsFragment();

            }
//            return new EmptyFragment();
        }

//        @Override
//        public CharSequence getPageTitle(int position){
//            return titles[position];
//        }

    }

}