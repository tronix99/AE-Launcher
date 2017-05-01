package com.arx_era.launcher;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class HomeActivity extends FragmentActivity {
    private ViewPager viewPager;
    private Screenadapters mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.screens);
        mAdapter = new Screenadapters(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(1);
    }
}
