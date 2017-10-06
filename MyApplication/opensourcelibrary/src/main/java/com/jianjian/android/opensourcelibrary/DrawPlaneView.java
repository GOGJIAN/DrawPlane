package com.jianjian.android.opensourcelibrary;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.jianjian.android.opensourcelibrary.models.Dot;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class DrawPlaneView extends View {

    private ArrayList<Path> mPaths = new ArrayList<>();
    private Path mCurrentPath;
    private Paint mBackGroundPaint;
    private Paint mPenPaint;
    private float mDotSize = 5;
    private int background = 0xfff8efe0;
    private int penColor = 0xFF000000;
    public DrawPlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBackGroundPaint = new Paint();
        mBackGroundPaint.setColor(background);

        mPenPaint = new Paint();
        mPenPaint.setColor(penColor);
        mPenPaint.setStyle(Paint.Style.STROKE);
        mPenPaint.setStrokeWidth(mDotSize);

    }

    public void setEraser(boolean isE){
        mPenPaint.setColor(isE?background:penColor);
    }

    public void setDotSize(float size){
        this.mDotSize = size;
    }

    public void setPenPaintColor(int colorInt){
        mPenPaint.setColor(colorInt);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(mBackGroundPaint);
        for(Path path : mPaths){
            canvas.drawPath(path,mPenPaint);
        }
        Log.d("My", "onDraw: ");
    }
    float lastX ;
    float lastY ;
    float cX ;
    float cY ;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();
                cX = event.getX();
                cY = event.getY();
                mCurrentPath = new Path();
                mCurrentPath.moveTo(lastX, lastY);
                mPaths.add(mCurrentPath);
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(lastX-event.getX());
                float dy = Math.abs(lastY-event.getY());


                if(dx>=3||dy>=3) {
                    mCurrentPath.quadTo(cX,cY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                    invalidate();
                }
                cX = event.getX();
                cY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mCurrentPath = null;

                break;
            case MotionEvent.ACTION_CANCEL:
                mCurrentPath = null;
                break;
        }
        return true;
    }
}
