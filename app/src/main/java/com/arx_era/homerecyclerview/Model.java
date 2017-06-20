package com.arx_era.homerecyclerview;

/**
 * Created by Tronix99 on 29-05-2017.
 */

public class Model {

    public static final int DT_CARD=0;
    public static final int PRO_CARD=1;
    public static final int FAVAPP_CARD=2;
    public static final int MUSIC_CARD=3;

    public int type;

    public Model(int type)
    {
        this.type=type;
    }
}