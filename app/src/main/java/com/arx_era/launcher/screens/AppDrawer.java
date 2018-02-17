package com.arx_era.launcher.screens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.arx_era.launcher.Pac;
import com.arx_era.launcher.R;
import com.arx_era.launcher.adapters.DrawerAdapter;
import com.arx_era.launcher.adapters.SortApps;
import com.arx_era.launcher.listeners.DrawerClickListener;

import java.util.List;

/**
 * Created by tronix99 on 9/2/18.
 */

public class AppDrawer extends Fragment{

    public AppDrawer() {
        // Required empty public constructor
    }

    DrawerAdapter drawerAdapterObject;
    GridView drawerGrid;
    Pac[] pacs;
    PackageManager pm;
    FrameLayout sbs;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.app_drawer, container, false);

        pm = getActivity().getPackageManager();
        drawerGrid = (GridView) v.findViewById(R.id.app_drawergrid);
        set_pacs();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            sbs = (FrameLayout) v.findViewById(R.id.status_barSize);
            sbs.setVisibility(View.VISIBLE);
        } else {
            sbs.setVisibility(View.GONE);
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        filter.addDataScheme("package");
        getContext().registerReceiver(new PacReceiver(), filter);

        return v;
    }

    public void set_pacs(){
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacsList = pm.queryIntentActivities(mainIntent, 0);
        pacs = new Pac[pacsList.size()];
        for(int I=0;I<pacsList.size();I++){
            pacs[I]= new Pac();
            pacs[I].icon=pacsList.get(I).loadIcon(pm);
            pacs[I].packageName=pacsList.get(I).activityInfo.packageName;
            pacs[I].name=pacsList.get(I).activityInfo.name.getClass().getSimpleName();
            pacs[I].label=pacsList.get(I).loadLabel(pm).toString();
        }
        new SortApps().exchange_sort(pacs);
        drawerAdapterObject = new DrawerAdapter(getActivity(), pacs);
        drawerGrid.setAdapter(drawerAdapterObject);
        drawerGrid.setOnItemClickListener(new DrawerClickListener(getActivity(), pacs, pm));
    }

    public class PacReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            set_pacs();
        }

    }

}