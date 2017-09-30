package com.jianjian.android.opensourcelibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.jianjian.android.opensourcelibrary.models.Dot;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class DrawPlaneView extends View {

    private ArrayList<Dot> dots = new ArrayList<>();
    private Paint mBackGroundPaint;
    private Paint mPenPaint;
    public DrawPlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBackGroundPaint = new Paint();
        mBackGroundPaint.setColor(0xfff8efe0);

        mPenPaint = new Paint();
        mPenPaint.setColor(0xFF000000);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(mBackGroundPaint);
        for(Dot dot:dots){
            float left = dot.getCoordinate().x-dot.getSize();
            float right = dot.getCoordinate().x+dot.getSize();
            float bottom = dot.getCoordinate().y+dot.getSize();
            float top = dot.getCoordinate().y-dot.getSize();
            canvas.drawOval(left,top,right,bottom,mPenPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF Point = new PointF(event.getX(), event.getY());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Dot firstDot = new Dot(Point);
                dots.add(firstDot);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Dot midDot = new Dot(Point);
                dots.add(midDot);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
