package com.arx_era.launcher.screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.arx_era.launcher.Pac;
import com.arx_era.launcher.R;
import com.arx_era.launcher.Settings;

/**
 * Created by tronix99 on 9/2/18.
 */

public class HomeScreen extends Fragment{

    private GestureDetector mDetector;
    Pac[] pacs;

    public HomeScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.home_screen, container, false);

        // get the gesture detector
        mDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onDown(MotionEvent event) {
                Log.d("TAG","onDown: ");
                // don't return false here or else none of the other
                // gestures will work

                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.i("TAG", "onSingleTapConfirmed: ");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
                startActivityForResult(pickWallpaper,1);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Intent i = new Intent(getActivity(), Settings.class);
                startActivity(i);
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                    float distanceX, float distanceY) {
                Log.i("TAG", "onScroll: ");
                return true;
            }

            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2,
                                   float velocityX, float velocityY) {
                Log.d("TAG", "onFling: ");
                return true;
            }


        });


        // Add a touch listener to the view
        // The touch listener passes all its events on to the gesture detector
        v.setOnTouchListener(touchListener);

        GridView dock = (GridView) v.findViewById(R.id.dock);

        return v;
    }

    // This touch listener passes everything on to the gesture detector.
    // That saves us the trouble of interpreting the raw touch events
    // ourselves.
    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // pass the events to the gesture detector
            // a return value of true means the detector is handling it
            // a return value of false means the detector didn't
            // recognize the event
            return mDetector.onTouchEvent(event);
        }
    };

    protected boolean paused = false;
    @Override
    public void onPause() {
        super.onPause();
        paused = true;
    }
    @Override
    public void onResume() {
        super.onResume();
        paused = false;
    }
}