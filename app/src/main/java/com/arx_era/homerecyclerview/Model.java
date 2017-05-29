package com.arx_era.homerecyclerview;

/**
 * Created by Tronix99 on 29-05-2017.
 */

public class Model {

    public static final int clock_card=0;
    public static final int pro_card=1;
    public static final int favapp_card=2;
    public static final int music_card=3;

    public int type;
    public int data;
    public String text;

    public Model(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }
}