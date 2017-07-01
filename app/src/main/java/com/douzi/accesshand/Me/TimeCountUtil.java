package com.douzi.accesshand.Me;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;

/**
 * Created by Douzi on 2017/6/30.
 */

public class TimeCountUtil extends CountDownTimer {

    private Activity mActivity;
    private Button btn;            //按钮

    public TimeCountUtil(Activity mActivity, long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);
        this.mActivity = mActivity;
        this.btn = btn;
    }

    @SuppressLint("NewApi")
    @Override
    public void onTick(long millisUntilFinished) {
        btn.setClickable(false);  //设置不能点击
        //设置倒计时时间
        btn.setText(millisUntilFinished / 1000 + "秒可以重新发送");

        //设置按钮为灰色, 这时是不能点击的
        //获取按钮文字
        Spannable span = new SpannableString(btn.getText().toString());
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        btn.setText(span);
    }

    @SuppressLint("NewApi")
    @Override
    public void onFinish() {
        btn.setText("重新获取验证码");
        btn.setClickable(true);     //重新点击
    }
}
