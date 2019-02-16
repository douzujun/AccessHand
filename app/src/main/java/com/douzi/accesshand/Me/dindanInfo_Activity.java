package com.douzi.accesshand.Me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/7.
 */

public class dindanInfo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dindan);

        ImageButton backBtn = (ImageButton) findViewById(R.id.btn_wei_left1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
