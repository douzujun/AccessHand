package com.douzi.accesshand.Me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.douzi.accesshand.Home.FragmentHome;
import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/7.
 */

public class pingjia_Activity extends AppCompatActivity {

    ImageButton backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjiasuccess);

        backBtn = (ImageButton) findViewById(R.id.btn_wei_left1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
