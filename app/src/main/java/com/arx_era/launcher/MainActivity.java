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

        init();
        panelListener();
    }

    public  void init(){
        slayout = (SlidingUpPanelLayout) findViewById(R.id.slideuppanel);
    }

    public void panelListener() {
        slayout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {

            // During the transition of expand and collapse onPanelSlide function will be called.
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.e(TAG, "onPanelSlide, offset " + slideOffset);
            }

            // This method will be call after slide up layout
            @Override
            public void onPanelExpanded(View panel) {
                Log.e(TAG, "onPanelExpanded");

            }

            // This method will be call after slide down layout.
            @Override
            public void onPanelCollapsed(View panel) {
                Log.e(TAG, "onPanelCollapsed");

            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.e(TAG, "onPanelAnchored");
            }

            @Override
            public void onPanelHidden(View panel) {
                Log.e(TAG, "onPanelHidden");
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (slayout != null &&
                (slayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || slayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            slayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {}
    }
}
