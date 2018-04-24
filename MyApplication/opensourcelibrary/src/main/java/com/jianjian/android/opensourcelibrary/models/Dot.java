package com.jianjian.android.opensourcelibrary.models;

import android.graphics.Path;
import android.graphics.PointF;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class Dot {

    private float Size;
    private int color;
    private Path mPath;

    public Path getPath() {
        return mPath;
    }

    public void setPath(Path path) {
        mPath = path;
    }

    public float getSize() {
        return Size;
    }

    public void setSize(float size) {
        Size = size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
