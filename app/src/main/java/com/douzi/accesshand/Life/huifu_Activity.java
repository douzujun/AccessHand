package com.douzi.accesshand.Life;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/23.
 */

public class huifu_Activity extends AppCompatActivity {

    private LinearLayout lie_1;

    private Button send_1;

    private EditText text_info;

    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huifu_activity);

        lie_1 = (LinearLayout) findViewById(R.id.icon_head_image4);
        send_1 = (Button) findViewById(R.id.send_1);
        text_info = (EditText) findViewById(R.id.text_info);

        send_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lie_1.setVisibility(View.VISIBLE);
                text_info.setText("");
            }
        });

        back = (ImageView) findViewById(R.id.btn_wei_left1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
