package com.douzi.accesshand.Me;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Douzi on 2017/7/3.
 */

import com.douzi.accesshand.R;

public class weiwancheng_Activity extends AppCompatActivity {

    private ImageButton backBtn;

    private Button confirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weiwancheng);

        backBtn = (ImageButton) findViewById(R.id.btn_wei_left1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmp = new Intent();
                tmp.putExtra("username","");
                tmp.putExtra("passwd","");
                setResult(1, tmp);
                finish();
            }
        });

        confirmBtn = (Button) findViewById(R.id.confirm_1);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weiwancheng_Activity.this, confirmActivity.class);
                startActivity(intent);
            }
        });

    }

}
