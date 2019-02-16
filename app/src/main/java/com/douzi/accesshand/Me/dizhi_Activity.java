package com.douzi.accesshand.Me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/17.
 */

public class dizhi_Activity extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dizhi_activity);

        backBtn = (ImageView) findViewById(R.id.btn_yi_left);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
