package com.jianjian.android.opensourcelibrary.models;

import android.graphics.PointF;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class Dot {
    private PointF mCoordinate;
    //半径
    private float Size;
    public Dot(PointF coordinate){
        this.mCoordinate = coordinate;
    }

    public PointF getCoordinate() {
        return mCoordinate;
    }

    public void setCoordinate(PointF coordinate) {
        mCoordinate = coordinate;
    }

    public float getSize() {
        return Size;
    }

    public void setSize(float size) {
        Size = size;
    }
}
