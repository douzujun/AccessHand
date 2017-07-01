package com.douzi.accesshand.Me;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;

public class Activity_login extends AppCompatActivity implements View.OnClickListener{

    ImageButton imageButton_return;    //返回按钮
    Button btn_login;                  //登录
    TextView textView_register;        //注册
    EditText user_name;                //用户名
    EditText user_passwd;              //密码
    String username; //保存注册页面传来的账号
    String passwd;   //保存注册页面传来的密码

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageButton_return = (ImageButton)findViewById(R.id.img_btn_arrow_left);
        textView_register = (TextView)findViewById(R.id.icon_register);
        btn_login = (Button)findViewById(R.id.icon_login);
        user_name = (EditText)findViewById(R.id.phone_number) ;
        user_passwd = (EditText)findViewById(R.id.phone_passwd);
        btn_login.setOnClickListener(this);
        imageButton_return.setOnClickListener(this);
        textView_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_btn_arrow_left:  //返回数据给上一活动
                Intent tmp = new Intent();
                tmp.putExtra("username", "");
                tmp.putExtra("passwd","");
                setResult(1, tmp);        //专门用于向上一个活动返回处理结果
                finish();
                break;
            case R.id.icon_register:      //注册
                //Toast.makeText(this,"You clicked register",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_login.this, Activity_register.class);
                startActivityForResult(intent, 1);      //对返回码进行处理
                break;
            case R.id.icon_login:         //登录
                if(!user_passwd.getText().toString().equals(passwd)) {
                    count++;
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("账号/密码错误");
                    if(count < 5) {
                        dialog.setMessage("您输入的账号/密码有误，登陆失败！" + "您还可以尝试" + (5 - count) + "次");
                    }else {
                        dialog.setMessage("对不起!您的账号已被锁定，请10分钟后再尝试！");
                    }
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
                    Toast.makeText(this,"登陆成功!", Toast.LENGTH_SHORT).show();
                    //调到我的信息界面(显示登录状态)
                    Intent username_passwd = new Intent();
                    username_passwd.putExtra("username", user_name.getText().toString());
                    username_passwd.putExtra("passwd",user_passwd.getText().toString());
                    setResult(1, username_passwd);
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:       //对注册界面requestCode进行处理
                username = data.getStringExtra("username"); //得到用户名和密码
                passwd = data.getStringExtra("passwd");
                user_name.setText(username.toCharArray(), 0, username.length());
                user_passwd.setText(passwd.toCharArray(),0, passwd.length());
                break;
            default:
                break;
        }
    }

}
