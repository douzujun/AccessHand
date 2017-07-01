package com.douzi.accesshand.Me;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.douzi.accesshand.R;

public class Activity_register extends AppCompatActivity implements View.OnClickListener{

    ImageButton btn_return_back;      //后退图片按钮
    Button btn_send_notice;           //发送验证码按钮
    Button btn_register;              //注册按钮
    EditText text_register_number;    //用户名(手机号) EditText
    EditText text_register_passwd;    //密码 EditText
    EditText text_reciive_notice;     //验证码 EditText
    String phone_register_number;     //得到手机号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_send_notice = (Button)findViewById(R.id.send_notice);
        btn_register = (Button)findViewById(R.id.icon_register);
        btn_return_back = (ImageButton)findViewById(R.id.btn_register_left);
        text_register_number = (EditText)findViewById(R.id.phone_register_number);
        text_register_passwd = (EditText)findViewById(R.id.phone_register_passwd);
        text_reciive_notice = (EditText)findViewById(R.id.phone_receive_notice);
        btn_return_back.setOnClickListener(this);
        btn_send_notice.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register_left:         //后退按钮
                //返回数据给上一个活动
                Intent tmp = new Intent();
                tmp.putExtra("username", "");    //获得
                tmp.putExtra("passwd", "");
                setResult(RESULT_OK, tmp);
                finish();
                break;
            case R.id.send_notice:
                phone_register_number = text_register_number.getText().toString();
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("400-000-000")
                        .setContentText("尊敬的"+phone_register_number+"用户您好！您的验证码为656863，有效期60秒。随手快递")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setSmallIcon(R.mipmap.icon_message)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.icon_message1))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("尊敬的用户您好！您的用户名为"+phone_register_number+"，验证码为656863，有效期60秒。随手快递"))
                        .build();
                manager.notify(1,notification);
                TimeCountUtil timeCountUtil = new TimeCountUtil(this, 60000, 1000, btn_send_notice);
                timeCountUtil.start();
                break;
            case R.id.icon_register:
                if(!(text_reciive_notice.getText().toString()).equals("656863")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("验证码错误");
                    dialog.setMessage("您输入的验证码有误，注册失败！");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                } else {
                    Toast.makeText(this, "注册成功！",Toast.LENGTH_SHORT).show();
                    Intent username_passwd = new Intent();
                    username_passwd.putExtra("username", text_register_number.getText().toString());
                    username_passwd.putExtra("passwd", text_register_passwd.getText().toString());
                    setResult(1, username_passwd);
                    finish();
                }
                break;
            default:
                break;
        }
    }
}