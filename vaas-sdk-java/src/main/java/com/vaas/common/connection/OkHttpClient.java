package com.vaas.common.connection;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OkHttpClient {

    private static final int CONN_TIMEOUT = 5000;
    private static final int REQ_TIMEOUT = 5000;
    private static final Logger LOG = LoggerFactory.getLogger(OkHttpClient.class);

    /**
     * 发送GET请求
     *
     * @param url 路径
     * @return String
     */
    public static String httpGet(String url) {
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS) // 连接超时
                .readTimeout(REQ_TIMEOUT, TimeUnit.SECONDS) //读取超时
                .build();
        HttpUrl httpUrl = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder().build();
        Request request = new Request.Builder().url(httpUrl.toString()).build();
        String result = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            if (response.isSuccessful() && body != null) {
                result = body.string();
            } else {
                LOG.error("error,statusCode={},body={}", response.code(), body == null ? "" : body.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String httpPost(String url, String content) {
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS) // 连接超时
                .readTimeout(REQ_TIMEOUT, TimeUnit.SECONDS) //读取超时
                .build();
        Request request = new Request.Builder().url(url)
                .post(RequestBody.create(MediaType.get("application/json"), content)).build();
        String result = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            if (response.isSuccessful() && body != null) {
                result = body.string();
            } else {
                LOG.error("error,statusCode={},body={}", response.code(), body == null ? "" : body.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
