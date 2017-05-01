package com.arx_era.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * Created by tronix99 on 28/4/17.
 */

public class AppDrawer extends Fragment {

    //class to store apps info and label
    class Pac {
        Drawable icon;
        String name;
        String label;
    }

    Pac[] pacs;
    PackageManager packagemanager;
    GridView appdrawergrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.appdrawer, container, false);

        packagemanager = getActivity().getPackageManager();
        appdrawergrid = (GridView) rootView.findViewById(R.id.appdrawer);

        return rootView;
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
    }
}
