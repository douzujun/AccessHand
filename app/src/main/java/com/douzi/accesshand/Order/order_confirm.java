package com.douzi.accesshand.Order;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.douzi.accesshand.Me.confirmActivity;
import com.douzi.accesshand.R;
import com.douzi.accesshand.view.Callback;
import com.douzi.accesshand.view.PasswordKeypad;

/**
 * Created by Douzi on 2017/7/9.
 */

public class order_confirm extends AppCompatActivity {

    //确认支付
    private PasswordKeypad mKeypad;
    private boolean state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_zhifu);

        //确认支付
        mKeypad = new PasswordKeypad();
        mKeypad.setPasswordCount(6);
        mKeypad.setCallback(new Callback() {
            @Override
            public void onForgetPassword() {
                Toast.makeText(order_confirm.this,"忘记密码",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onInputCompleted(CharSequence password) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (state) {
                            mKeypad.setPasswordState(true);
                            state = false;
                        } else {
                            mKeypad.setPasswordState(false, "密码输入错误");
                            state = true;
                        }
                    }
                },1000);
            }

            @Override
            public void onPasswordCorrectly() {
                Intent intent = new Intent(order_confirm.this, confirmActivity.class);
                startActivity(intent);
                mKeypad.dismiss();
            }

            @Override
            public void onCancel() {
                //todo:做一些埋点类的需求
            }
        });
//o
        //调用确认支付, 跳出支付页面
//        Toast.makeText(order_confirm.this, "支付成功", Toast.LENGTH_LONG).show();
        mKeypad.show(getSupportFragmentManager(),  "PasswordKeypad");
    }
}
