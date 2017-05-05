package com.weinp.tgnet.secondlearningproject;

import android.app.Application;

/**
 * Created by weinp on 2017/5/5.
 * <p>
 * 提供全局的Context
 */

public class YwqApplication extends Application {

    private static YwqApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static YwqApplication getInstance() {
        return application;
    }
}
