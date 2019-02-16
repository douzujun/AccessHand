package com.douzi.accesshand.Life;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/19.
 */

public class tongzhi_Activity extends AppCompatActivity {

    private TextView pinglunInfo;

    private ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hudong_activity);

        pinglunInfo = (TextView) findViewById(R.id.tongzhi_info);

        pinglunInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tongzhi_Activity.this, askinfo_Activity.class);
                startActivity(intent);
            }
        });

        backBtn = (ImageView) findViewById(R.id.btn_wei_left1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}










