package com.example.ravinderreddy.viewpager26;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FliperFragment.OnFragmentInteractionListener {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.activity_main_vipa);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
    }


    public void onBackClick(View view) {
        if(viewPager.getCurrentItem() > 0)
        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);


    }


    public void onSkipClick(View vew) {
        if(viewPager.getCurrentItem() < 4)
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
