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
    private float mDotSize = 2;
    public DrawPlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBackGroundPaint = new Paint();
        mBackGroundPaint.setColor(0xfff8efe0);

        mPenPaint = new Paint();
        mPenPaint.setColor(0xFF000000);
        mPenPaint.setStyle(Paint.Style.STROKE);
        mPenPaint.setStrokeWidth(5);

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
//            float left = dot.getCoordinate().x-dot.getSize();
//            float right = dot.getCoordinate().x+dot.getSize();
//            float bottom = dot.getCoordinate().y+dot.getSize();
//            float top = dot.getCoordinate().y-dot.getSize();
//            canvas.drawOval(left,top,right,bottom,mPenPaint);
            canvas.drawPath(path,mPenPaint);

        }
        Log.d("My", "onDraw: ");
    }
    float lastX ;
    float lastY ;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();
                mCurrentPath = new Path();
                mCurrentPath.moveTo(lastX, lastY);
                mPaths.add(mCurrentPath);
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(lastX-event.getX());
                float dy = Math.abs(lastY-event.getY());
                if(dx>3||dy>3) {
                    mCurrentPath.quadTo(lastX, lastY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                    invalidate();
                }
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
