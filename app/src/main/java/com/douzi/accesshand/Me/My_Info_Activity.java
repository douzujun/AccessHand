package com.douzi.accesshand.Me;

import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.douzi.accesshand.R;


public class My_Info_Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton myinfo_Left;
    private Button myinfo_Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        myinfo_Left = (ImageButton)findViewById(R.id.btn_myinfo_left);
        myinfo_Save = (Button)findViewById(R.id.icon_myinfo_save);
        myinfo_Save.setOnClickListener(this);
        myinfo_Left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_myinfo_left:
                finish();
                break;
            case R.id.icon_myinfo_save:
                Toast.makeText(getBaseContext(),"保存成功",Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
    }
}

