package com.douzi.accesshand.Order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douzi.accesshand.R;

/**
 * Created by quan on 2017/3/22.
 */

public class FragmentOrder extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,null);
        return view;
    }
}
