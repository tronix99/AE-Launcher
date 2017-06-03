package com.arx_era.homerecyclerview;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arx_era.launcher.R;

import java.util.ArrayList;
/**
 * Created by Tronix99 on 30-05-2017.
 */

public class MultiViewTypeAdapter extends RecyclerView.Adapter{
    ArrayList dataSet;
    Context mContext;
    int total_types;

    public static class DtViewHolder extends RecyclerView.ViewHolder {
        public DtViewHolder(View itemView) {
            super(itemView);

        }
    }

    public MultiViewTypeAdapter(ArrayList data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.dt_card:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dt_card, parent, false);
                return new DtViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Model object = (Model) dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.dt_card:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
