package com.weinp.tgnet.secondlearningproject.network.http;

import com.weinp.tgnet.practicallibrary.okhttp.CommonOkhttpClient;
import com.weinp.tgnet.practicallibrary.okhttp.listener.DisposeDataHandle;
import com.weinp.tgnet.practicallibrary.okhttp.listener.DisposeDataListener;
import com.weinp.tgnet.practicallibrary.okhttp.request.CommonRequest;
import com.weinp.tgnet.practicallibrary.okhttp.request.RequestParams;
import com.weinp.tgnet.secondlearningproject.module.recommoand.BaseRecommandModule;
import com.weinp.tgnet.secondlearningproject.module.recommoand.RecommandModule;

/**
 * Created by tgnet on 2017/5/5.
 */

public class RequestCenter {

    private static void postRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> clazz) {
        CommonOkhttpClient.get(CommonRequest.onCreateGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    /**
     * 首页请求接口
     *
     * @param listener
     */
    public static void requestReCommondData(DisposeDataListener listener) {
        postRequest(HttpConstants.HOME_RECOMMAND, null, listener, BaseRecommandModule.class);

    }
}
