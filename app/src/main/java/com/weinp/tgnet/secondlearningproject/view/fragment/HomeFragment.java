package com.weinp.tgnet.secondlearningproject.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weinp.tgnet.secondlearningproject.R;
import com.weinp.tgnet.secondlearningproject.view.fragment.base.BaseFragment;

/**
 * Created by tgnet on 2017/5/5.
 */

public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, null);
        return view;
    }
}
