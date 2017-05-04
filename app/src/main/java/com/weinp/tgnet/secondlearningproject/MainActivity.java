package com.weinp.tgnet.secondlearningproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weinp.tgnet.practicallibrary.okhttp.CommonOkhttpClient;
import com.weinp.tgnet.practicallibrary.okhttp.listener.DisposeDataHandle;
import com.weinp.tgnet.practicallibrary.okhttp.listener.DisposeDataListener;
import com.weinp.tgnet.practicallibrary.okhttp.request.CommonRequest;
import com.weinp.tgnet.practicallibrary.okhttp.response.CommonJsonCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(){
        CommonOkhttpClient.sendRequest(CommonRequest.createPostRequest("http://www.baidu.com", null),
                new CommonJsonCallBack(new DisposeDataHandle(new DisposeDataListener() {
                    @Override
                    public void onSucess(Object responseObj) {

                    }

                    @Override
                    public void onFailure(Object responseObj) {

                    }
                },null)));
    }
}
