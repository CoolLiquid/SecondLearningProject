package com.weinp.tgnet.practicallibrary.okhttp.request;

/**
 * Created by weinp on 2017/5/3.
 */

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weinp
 * @Function Request 请求参数
 */

public class RequestParams {
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<>();


    public RequestParams() {
        this((Map<String, String>) null);
    }

    /**
     * @param source the source key/value string map to add.
     */
    public RequestParams(Map<String, String> source) {
        if (source != null) {
            for (Map.Entry<String, String> entry :
                    source.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * @param key
     * @param value
     */
    public RequestParams(final String key, final String value) {

        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });
    }

    /**
     * @param key
     * @param value
     */
    private void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    /**
     * @param key
     * @param value
     */
    private void put(String key, Object value) throws FileNotFoundException {
        if (key != null && value != null) {
            fileParams.put(key, value);
        }
    }

    public boolean hasParams() {
        if (urlParams.size() > 0 || fileParams.size() > 0) {
            return true;
        }
        return false;
    }

}
