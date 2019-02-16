package com.douzi.accesshand.Life;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.douzi.accesshand.R;
import com.iflytek.cloud.thirdparty.V;

/**
 * Created by Douzi on 2017/7/18.
 */

public class askinfo_Activity extends AppCompatActivity {

    private ImageView backBtn;

    private ImageView guanzhu_1;

    private ImageView guanzhu_2;

    private LinearLayout add_1;

    private ImageView zan_1;

    private ImageView zan_2;

    private LinearLayout pinglun_1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.askinfo_activity);

        backBtn = (ImageView) findViewById(R.id.btn_wei_left1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        guanzhu_1 = (ImageView) findViewById(R.id.guanzhu_2);
        guanzhu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guanzhu_1.setVisibility(View.GONE);
                guanzhu_2.setVisibility(View.VISIBLE);
            }
        });

        guanzhu_2 = (ImageView) findViewById(R.id.guanzhu_3);
        guanzhu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guanzhu_2.setVisibility(View.GONE);
                guanzhu_1.setVisibility(View.VISIBLE);
                Toast.makeText(askinfo_Activity.this, "关注成功", Toast.LENGTH_SHORT).show();
            }
        });

        add_1 = (LinearLayout) findViewById(R.id.add_f);
        add_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(askinfo_Activity.this);
                builder.setTitle("通知");
                builder.setMessage("已向对方发送添加好友通知 !");
                builder.setCancelable(false);
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        zan_1 = (ImageView) findViewById(R.id.zan_1);
        zan_2 = (ImageView) findViewById(R.id.zan_2);
        zan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zan_1.setVisibility(View.GONE);
                zan_2.setVisibility(View.VISIBLE);
            }
        });

        zan_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zan_2.setVisibility(View.GONE);
                zan_1.setVisibility(View.VISIBLE);
            }
        });

        pinglun_1 = (LinearLayout) findViewById(R.id.pinglun_1);
        pinglun_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(askinfo_Activity.this, "评价成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(askinfo_Activity.this, huifu_Activity.class);
                startActivity(intent);
            }
        });

    }
}
