package com.example.jian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jianjian.android.opensourcelibrary.DrawPlaneView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawPlaneView dpv = (DrawPlaneView)findViewById(R.id.draw_plane_view);
        dpv.setDotSize(5);
        dpv.setPenPaintColor(0xFFFF0000);
    }
}
