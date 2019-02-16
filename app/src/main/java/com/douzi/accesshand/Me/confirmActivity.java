package com.douzi.accesshand.Me;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.douzi.accesshand.Order.context_Activity;
import com.douzi.accesshand.R;

/**
 * Created by Douzi on 2017/7/6.
 */

public class confirmActivity extends Activity {

    private ImageButton backBtn;
    private Button talkBtn;          //立即评价
    private Button talkBtn2;         //订单详情
    private Button callBtn3;         //联系员工
    private Button addBtn4;          //添加好友

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaoyisuccess);

        //返回
        backBtn = (ImageButton) findViewById(R.id.btn_wei_left1);
        //立即评价
        talkBtn = (Button) findViewById(R.id.talk_1);
        //订单详情
        talkBtn2 = (Button) findViewById(R.id.talk_2);
        //联系员工
        callBtn3 = (Button) findViewById(R.id.call_1);
        //添加好友
        addBtn4 = (Button) findViewById(R.id.add_1);

        //后退
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmp = new Intent();
                tmp.putExtra("username","");
                tmp.putExtra("passwd","");
                setResult(1, tmp);
                finish();
            }
        });

        //立即评价
        talkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmActivity.this, context_Activity.class);
                startActivity(intent);
            }
        });

        //订单详情
        talkBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmActivity.this, dindanInfo_Activity.class);
                startActivity(intent);
            }
        });

        //联系员工
        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:17805054367"));
                startActivity(intent);
            }
        });

        //添加好友
        addBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(confirmActivity.this);
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

    }

}
