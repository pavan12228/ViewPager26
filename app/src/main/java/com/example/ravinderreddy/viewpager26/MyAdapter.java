package com.example.ravinderreddy.viewpager26;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ravinder Reddy on 29-07-2017.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FliperFragment.newInstance(String.valueOf(position));
    }

    @Override
    public int getCount() {
        return 4;
    }
}
