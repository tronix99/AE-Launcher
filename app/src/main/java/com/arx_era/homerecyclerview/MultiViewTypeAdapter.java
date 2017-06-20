package com.arx_era.homerecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            CardView dtview = (CardView) itemView.findViewById(R.id.dt_view);
            dtview.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    public static class ProViewHolder extends RecyclerView.ViewHolder {
        public ProViewHolder(View itemView) {
            super(itemView);
            CardView proview = (CardView) itemView.findViewById(R.id.pro_view);
            proview.setBackgroundColor(Color.parseColor("#ffffff"));
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
            case Model.DT_CARD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dt_card, parent, false);
                return new DtViewHolder(view);
            case Model.PRO_CARD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pro_card, parent, false);
                return new ProViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Model object = (Model) dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.DT_CARD:
                    break;
                case Model.PRO_CARD:
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int viewType) {
        switch (viewType) {
            case Model.DT_CARD:
                return Model.DT_CARD;
            case Model.PRO_CARD:
                return Model.PRO_CARD;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
