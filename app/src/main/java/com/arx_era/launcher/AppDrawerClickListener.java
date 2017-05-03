package com.arx_era.launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by tronix99 on 3/5/17.
 */

public class AppDrawerClickListener implements OnItemClickListener{

    Context mContext;
    AppDrawer.Pac[] pacsForAdapter;
    PackageManager packageManagerForListener;

    public AppDrawerClickListener(Context c, AppDrawer.Pac[] pacs, PackageManager packageManager){
        mContext = c;
        pacsForAdapter = pacs;
        packageManagerForListener = packageManager;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent launchIntent = packageManagerForListener.getLaunchIntentForPackage(pacsForAdapter[position].name);
        mContext.startActivity(launchIntent);
    }
}
