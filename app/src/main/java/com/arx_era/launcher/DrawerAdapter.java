package com.arx_era.launcher;

import android.content.Context;
import android.support.annotation.MainThread;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by tronix99 on 1/5/17.
 */

public class DrawerAdapter extends BaseAdapter {
    Context mContext;
    AppDrawer.Pac[] pacsForAdapter;

    public DrawerAdapter (Context c, AppDrawer.Pac pacs[]){
        mContext = c;
        pacsForAdapter = pacs;
    }

    @Override
    public int getCount() {
        return pacsForAdapter.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageDrawable(pacsForAdapter[pos].icon);
        imageView.setLayoutParams(new GridView.LayoutParams(115, 115));
        imageView.setPadding(5, 5, 5, 5);
        return imageView;
    }
}
