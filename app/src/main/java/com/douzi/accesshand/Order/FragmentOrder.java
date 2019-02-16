package com.douzi.accesshand.Order;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;
import com.douzi.accesshand.view.Callback;
import com.douzi.accesshand.view.PasswordKeypad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quan on 2017/3/22.
 */

public class FragmentOrder extends Fragment implements View.OnClickListener{

    private Button context;
    private Button again;
    private Button confirm;
    private Button quxiao2;
    private TextView Order_state1;
    private TextView quxiao_text;
    private Intent intent;
    private RelativeLayout dingdan1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,null);

        permission();

        context = (Button)view.findViewById(R.id.context_1);
        again = (Button)view.findViewById(R.id.again_1);
        confirm = (Button)view.findViewById(R.id.confirm_1);
        Order_state1 = (TextView)view.findViewById(R.id.order_state);
        quxiao2 = (Button)view.findViewById(R.id.quciao2);
        quxiao_text = (TextView)view.findViewById(R.id.quxiao2_text);
        dingdan1 = (RelativeLayout)view.findViewById(R.id.dingdan_1);
        dingdan1.setOnClickListener(this);
        quxiao2.setOnClickListener(this);
        context.setOnClickListener(this);
        again.setOnClickListener(this);
        confirm.setOnClickListener(this);

        return view;
    }

    public void permission(){
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions((Activity) getContext(), permissions, 1);
        } else {
            //requestLocation();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.context_1:
//                Toast.makeText(getContext(),"去评价",Toast.LENGTH_SHORT).show();
                Order_state1.setText("已完成");
                intent = new Intent(getContext(),context_Activity.class);
                startActivity(intent);
                break;
            case R.id.again_1:
                Order_state1.setText("已取消");
                break;
            case R.id.quciao2:
                quxiao_text.setText("已取消");
                break;
            case R.id.confirm_1:
                //Order_state1.setTextColor(Color.rgb(34, 110, 34));
                if(confirm.getText().equals("确认接单"))
                {
                    confirm.setText("完成订单");
                    Order_state1.setText("待完成");
                }else if(confirm.getText().equals("确认收货")){

                    intent = new Intent(getContext(), order_confirm.class);
                    startActivity(intent);

                    Order_state1.setTextColor(Color.rgb(34, 110, 34));
                    Order_state1.setText("已完成");
                }
                break;
            case R.id.dingdan_1:
//                intent = new Intent(getContext(),map_Activity.class);
//                startActivity(intent);
                break;
            default:
                break;
        }
    }

}

