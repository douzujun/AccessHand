package com.douzi.accesshand.Me;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;


/**
 * Created by Douzi on 2017/3/22.
 */

public class FragmentMe extends Fragment implements View.OnClickListener {

    TextView icon_my_name;
    private LinearLayout weiwancheng;
    private LinearLayout yiwancheng;
    private LinearLayout daipingjia;
    private LinearLayout my_Info;
    private LinearLayout my_wallet;
    private LinearLayout my_adress;
    private LinearLayout my_youhui;
    private LinearLayout my_jifen;
    private LinearLayout my_kefu;
    private Intent intent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,null);
        //数据初始化
        icon_my_name = (TextView)view.findViewById(R.id.my_name);
        weiwancheng = (LinearLayout)view.findViewById(R.id.ic_weiwancheng);
        yiwancheng = (LinearLayout)view.findViewById(R.id.ic_yiwancheng);
        daipingjia = (LinearLayout)view.findViewById(R.id.ic_daipingjia);
        my_Info = (LinearLayout)view.findViewById(R.id.ic_my_info);
        my_wallet = (LinearLayout)view.findViewById(R.id.ic_my_wallet);
        my_adress = (LinearLayout)view.findViewById(R.id.ic_my_adress);
        my_youhui = (LinearLayout)view.findViewById(R.id.ic_my_youhui);
        my_jifen = (LinearLayout)view.findViewById(R.id.ic_my_jifen);
        my_kefu = (LinearLayout)view.findViewById(R.id.ic_my_kefu);
        my_kefu.setOnClickListener(this);
        my_jifen.setOnClickListener(this);
        my_youhui.setOnClickListener(this);
        my_adress.setOnClickListener(this);
        my_wallet.setOnClickListener(this);
        my_Info.setOnClickListener(this);
        daipingjia.setOnClickListener(this);
        yiwancheng.setOnClickListener(this);
        weiwancheng.setOnClickListener(this);
        icon_my_name.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_name:
                intent = new Intent(getContext(),Activity_login.class);
                startActivityForResult(intent,1);
                break;
//            case R.id.ic_weiwancheng:
//                intent = new Intent(getContext(),weiwancheng_Activity.class);
//                startActivityForResult(intent,1);
//                break;
//            case R.id.ic_yiwancheng:
//                intent = new Intent(getContext(),yiwancheng_Activity.class);
//                startActivityForResult(intent,1);
//                break;
//            case R.id.ic_daipingjia:
//                Toast.makeText(getContext(),"待评价",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.ic_my_info:
//                intent = new Intent(getContext(),My_Info_Activity.class);
//                startActivity(intent);
//                break;
//            case R.id.ic_my_wallet:
//                intent = new Intent(getContext(),aypayment_Activity.class);
//                startActivity(intent);
//                break;
            case R.id.ic_my_adress:
                Toast.makeText(getContext(),"我的地址",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_my_youhui:
                Toast.makeText(getContext(),"我的认证",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_my_jifen:
                Toast.makeText(getContext(),"常见问题",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_my_kefu:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:4000-000-000"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                String username = data.getStringExtra("username");
                String passwd = data.getStringExtra("passwd");
                if(!username.equals("")) {
                    icon_my_name.setText(username.toCharArray(),0,username.length());
                }
                break;
            default:
                break;
        }
    }
}
