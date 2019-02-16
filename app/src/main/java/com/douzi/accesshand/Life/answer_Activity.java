package com.douzi.accesshand.Life;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/18.
 */

public class answer_Activity extends AppCompatActivity {

    private LinearLayout first_1;

    private ImageView tiwen_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_activity);

        first_1 = (LinearLayout) findViewById(R.id.first_1);
        first_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(answer_Activity.this, askinfo_Activity.class);
                startActivity(intent);
            }
        });

        tiwen_1 = (ImageView) findViewById(R.id.tiwen_1);
        tiwen_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(answer_Activity.this, tiwen_Activity.class);
                startActivity(intent);
            }
        });



    }
}
