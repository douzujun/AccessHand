package com.douzi.accesshand.Life;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/18.
 */

public class dongtaiActivity extends AppCompatActivity {

    private Button guanzhu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanzhu_activity);

        guanzhu = (Button) findViewById(R.id.guanzhu_btn);
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dongtaiActivity.this);
                builder.setTitle("通知");
                builder.setMessage("确认收藏该店铺？");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
            }
        });

    }
}
