package com.arx_era.launcher.listeners;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.arx_era.launcher.Pac;


/**
 * Created by tronix99 on 11/2/18.
 */

public class DrawerClickListener implements OnItemClickListener {

    Context mContext;
    Pac[] pacsForAdapter;
    PackageManager pmForListener;

    public DrawerClickListener(Context c, Pac[] pacs, PackageManager pm) {
        mContext = c;
        pacsForAdapter = pacs;
        pmForListener = pm;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
        Intent launchIntent = new Intent(Intent.ACTION_MAIN);
        launchIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cp = new ComponentName(pacsForAdapter[pos].packageName, pacsForAdapter[pos].name);
        launchIntent.setComponent(cp);
        mContext.startActivity(launchIntent);
        Log.d(pacsForAdapter[pos].packageName.toString(), pacsForAdapter[pos].name.toString());
    }

}