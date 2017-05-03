package com.arx_era.launcher;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tronix99 on 1/5/17.
 */

public class AppDrawerAdapter extends BaseAdapter {
    Context mContext;
    AppDrawer.Pac[] pacsForAdapter;

    public AppDrawerAdapter(Context c, AppDrawer.Pac pacs[]){
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

    static class viewHolder{
        TextView text;
        ImageView icon;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        viewHolder viewHolder;
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.appdrawer_items, null);

            viewHolder = new viewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.icon_text);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon_image);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
        }

        viewHolder.text.setText(pacsForAdapter[pos].label);
        viewHolder.icon.setImageDrawable(pacsForAdapter[pos].icon);

        return convertView;
    }
}
