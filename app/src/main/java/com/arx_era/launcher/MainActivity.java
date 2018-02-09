package com.arx_era.launcher;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.arx_era.launcher.screens.AppDrawer;
import com.arx_era.launcher.screens.HomeScreen;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        StatusBarUtil.setTranslucent(MainActivity.this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
   }

    private void setupViewPager(ViewPager viewPager) {
        MainActivityScreens adapter = new MainActivityScreens(getSupportFragmentManager());
        adapter.addFragment(new HomeScreen(), "Home");
        adapter.addFragment(new AppDrawer(), "AppDrawer");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
    }
}
