package com.weinp.tgnet.secondlearningproject.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by tgnet on 2017/5/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    String Tag = null;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tag = getComponentName().getShortClassName();
        Toast.makeText(this, Tag, Toast.LENGTH_SHORT).show();
        initView(savedInstanceState);
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
