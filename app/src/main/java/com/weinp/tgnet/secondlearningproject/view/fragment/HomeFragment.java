package com.weinp.tgnet.secondlearningproject.view.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.weinp.tgnet.practicallibrary.okhttp.listener.DisposeDataListener;
import com.weinp.tgnet.secondlearningproject.R;
import com.weinp.tgnet.secondlearningproject.network.http.RequestCenter;
import com.weinp.tgnet.secondlearningproject.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tgnet on 2017/5/5.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.qrcode_view)
    TextView qrcodeView;
    @BindView(R.id.category_view)
    TextView categoryView;
    @BindView(R.id.search_view)
    TextView searchView;
    @BindView(R.id.loading_view)
    ImageView loadingView;
    @BindView(R.id.list_view)
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestReCommanData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, null);
        ButterKnife.bind(this, view);
        AnimationDrawable animationDrawable = (AnimationDrawable) loadingView.getDrawable();
        animationDrawable.start();//启动动画
        return view;
    }

    /**
     * 发送首页列表请求
     */
    private void requestReCommanData() {
        RequestCenter.requestReCommondData(new DisposeDataListener() {
            @Override
            public void onSucess(Object responseObj) {

            }

            @Override
            public void onFailure(Object responseObj) {
                //提示用户网络有问题
            }
        });
    }
}
