package com.arx_era.launcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tronix on 09-04-2017.
 */

public class Screenadapters extends FragmentPagerAdapter {

    public Screenadapters(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new Home();
            case 1:
                return new Home();
            case 2:
                return new Home();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
