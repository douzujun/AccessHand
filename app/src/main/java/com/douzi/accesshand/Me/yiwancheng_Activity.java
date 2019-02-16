package com.douzi.accesshand.Me;

/**
 * Created by Douzi on 2017/7/3.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.douzi.accesshand.Order.context_Activity;
import com.douzi.accesshand.R;


public class yiwancheng_Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton yi_Left;

    private Button pingja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yiwancheng);
        yi_Left = (ImageButton) findViewById(R.id.btn_yi_left);
        yi_Left.setOnClickListener(this);

        pingja = (Button) findViewById(R.id.trace_1);
        pingja.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_yi_left:
                Intent tmp = new Intent();
                tmp.putExtra("username","");
                tmp.putExtra("passwd","");
                setResult(1,tmp);
                finish();
                break;
            case R.id.trace_1:
                Intent intent = new Intent(yiwancheng_Activity.this,context_Activity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}

