package com.arx_era.launcher;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private Screenadapters mAdapter;
    private SlidingUpPanelLayout slayout;
    private static final String TAG = "MainAcitvity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.screens);
        mAdapter = new Screenadapters(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onBackPressed() {
    }
}
