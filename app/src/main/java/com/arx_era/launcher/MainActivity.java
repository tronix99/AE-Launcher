package com.arx_era.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.arx_era.homerecyclerview.Model;
import com.arx_era.homerecyclerview.MultiViewTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends FragmentActivity {
    AppDrawerAdapter drawerAdapterObject;

    //class to store apps info and label
    class Pac {
        Drawable icon;
        String name;
        String label;
    }

    MainActivity.Pac[] pacs;
    PackageManager packagemanager;
    GridView appdrawergrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        appdrawergrid = (GridView) findViewById(R.id.appdrawer);
        appdrawergrid.setFastScrollEnabled(true);
        packagemanager = getPackageManager();
        set_pacs();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        filter.addDataScheme("package");
        registerReceiver(new pacsReceiver(), filter);

        ArrayList list= new ArrayList();
        list.add(new Model(Model.DT_CARD));
        list.add(new Model(Model.PRO_CARD));
        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.screen);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void set_pacs(){
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacsList = packagemanager.queryIntentActivities(mainIntent, 0);
        pacs = new Pac[pacsList.size()];
        for(int i=0; i<pacsList.size(); i++){
            pacs[i] = new Pac();
            pacs[i].icon=pacsList.get(i).loadIcon(packagemanager);
            pacs[i].name =  pacsList.get(i).activityInfo.packageName;
            pacs[i].label = pacsList.get(i).loadLabel(packagemanager).toString();
        }
        new SortApps().exchange_sort(pacs);
        drawerAdapterObject = new AppDrawerAdapter(this, pacs);
        appdrawergrid.setAdapter(drawerAdapterObject);
        appdrawergrid.setOnItemClickListener(new AppDrawerClickListener(this, pacs, packagemanager));
    }

    public class pacsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            set_pacs();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
