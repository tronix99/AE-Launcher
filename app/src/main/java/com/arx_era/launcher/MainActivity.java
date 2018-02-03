package com.arx_era.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.arx_era.WallpaperChooser.WallpaperChooser;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        View home = findViewById(R.id.HomeLayout);
        home.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, WallpaperChooser.class);
                startActivity(Intent.createChooser(intent, "Select Wallpaper"));
                return false;
            }
        });
   }

    @Override
    public void onBackPressed() {
    }
}
