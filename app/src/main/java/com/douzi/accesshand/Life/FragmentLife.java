package com.douzi.accesshand.Life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.douzi.accesshand.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Douzi on 2017/3/22.
 */

public class FragmentLife extends Fragment {

    private LinearLayout likeImage;

    private LinearLayout askImage;

    private LinearLayout hudong;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life,null);


        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                refreshLife();
            }
        });

        likeImage = (LinearLayout) view.findViewById(R.id.guanzhu_1);
        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), dongtaiActivity.class);
                startActivity(intent);
            }
        });

        askImage = (LinearLayout) view.findViewById(R.id.answer_1);
        askImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), answer_Activity.class);
                startActivity(intent);
            }
        });

        hudong = (LinearLayout) view.findViewById(R.id.notice_1);
        hudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), tongzhi_Activity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    private void initFruits() {
        for (int i = 0; i < 50; i++) {

        }
    }

    private void refreshLife() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Activity activity = (Activity)getContext();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                    }
                });
            }
        }).start();

    }

}
