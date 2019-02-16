package com.douzi.accesshand.Life;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/19.
 */

public class tiwen_Activity extends AppCompatActivity {

    private ImageView backBtn;

    private TextView fabuBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiwen_activity);

        backBtn = (ImageView) findViewById(R.id.btn_yi_left);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fabuBtn = (TextView) findViewById(R.id.fabu);
        fabuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tiwen_Activity.this, "发布成功 ！", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
