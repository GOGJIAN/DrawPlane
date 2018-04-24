package com.example.jian.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.jianjian.android.opensourcelibrary.DrawPlaneView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawPlaneView dpv;
    private Button revokeBtn;
    private Spinner chooseColor;
    private CheckBox isEraser;
    private EditText lineWidth;
    private Button okBtn;
    private FloatingActionButton clearBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dpv = (DrawPlaneView)findViewById(R.id.draw_plane_view);
        revokeBtn = (Button)findViewById(R.id.revoke_action);
        revokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpv.revoke();
            }
        });
        chooseColor = (Spinner)findViewById(R.id.color_spinner);

        chooseColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        dpv.setPenPaintColor(0xFFFF0000);
                        break;
                    case 1:
                        dpv.setPenPaintColor(0xFF00FF00);
                        break;
                    case 2:
                        dpv.setPenPaintColor(0xFF0000FF);
                        break;
                }
                isEraser.setChecked(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        isEraser = (CheckBox)findViewById(R.id.isEraser);
        isEraser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                dpv.setEraser(b);
            }
        });
        lineWidth = (EditText)findViewById(R.id.dotSize_edit);
        okBtn = (Button)findViewById(R.id.set_width);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lineWidth.getText()!=null)
                dpv.setDotSize(Float.valueOf(lineWidth.getText().toString()));
            }
        });
        clearBtn = (FloatingActionButton)findViewById(R.id.fab);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpv.clear();
            }
        });
        dpv.setDotSize(5);
        dpv.setPenPaintColor(0xFFFF0000);
    }
}
