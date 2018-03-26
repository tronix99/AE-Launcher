package com.arx_era.launcher.listeners;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.arx_era.launcher.R;

/**
 * Created by tronix99 on 17/2/18.
 */

public class DrawerLongPressListener implements OnItemLongClickListener {

    Context mContext;
    GridView gridView;

    public DrawerLongPressListener(Context c, GridView gv) {
        mContext = c;
        gridView = gv;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View item, int arg2,
                                   long arg3) {
        return true;
    }

}
