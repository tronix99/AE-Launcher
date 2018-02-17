package com.arx_era.launcher;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.arx_era.launcher.adapters.MainActivityScreens;
import com.arx_era.launcher.screens.AppDrawer;
import com.arx_era.launcher.screens.HomeScreen;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    MainActivityScreens adapter;


    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        adapter = new MainActivityScreens(getSupportFragmentManager());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            FrameLayout sbs = (FrameLayout) findViewById(R.id.status_barSize);
            sbs.setBackground(getResources().getDrawable(R.drawable.fade));
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*View v = findViewById(R.id.HomeLayout);
                if (position == 0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        v.setSystemUiVisibility(0);
                    }
                }
                if (position == 1){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                }*/
                if(position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
                    // the last page color
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
        setUpColors();
   }

    private void setUpColors(){
        Integer color1 = getResources().getColor(R.color.transparent);
        Integer color2 = getResources().getColor(R.color.halftransparent);

        Integer[] colors_temp = {color1, color2};
        colors = colors_temp;

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new HomeScreen(), "Home");
        adapter.addFragment(new AppDrawer(), "AppDrawer");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        viewPager.setCurrentItem(0, true);
    }
}
