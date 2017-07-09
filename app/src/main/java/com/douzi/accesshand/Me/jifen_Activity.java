package com.douzi.accesshand.Me;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/8.
 */

public class jifen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jifen);

        final Button jifenBtn = (Button) findViewById(R.id.jifenbtn);
        jifenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(jifen_Activity.this, "兑换商品" , Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(jifen_Activity.this);
                builder.setTitle("通知");
                builder.setMessage("您将消耗1000积分进行抽奖");

                builder.setPositiveButton("确认",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        ImageButton backBtn = (ImageButton) findViewById(R.id.btn_yi_left);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
