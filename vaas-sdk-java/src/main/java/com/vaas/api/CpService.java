package com.vaas.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.vaas.api.entity.*;
import com.vaas.common.connection.OkHttpClient;
import com.vaas.common.utils.ConfigMap;
import com.vaas.common.utils.Aes;
import com.vaas.common.utils.GenerateSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作者服务
 */
public class CpService {

    private final JSONObject params;
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static final Gson GSON = new Gson();
    private static final String SERV_CP_INFO = "/video/cpinfo";
    private static final String SERV_CP_VIDEOS = "/video/cpvideos";

    public CpService(JSONObject params) {
        this.params = params;
    }

    /**
     * 获取作者详情
     *
     * @param id        作者 ID
     * @param videoType 视频类型，1-横屏，2-竖屏
     * @return Cp 作者对象信息
     */
    public Cp cpInfo(String id, int videoType) {
        Cp info = new Cp();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_CP_INFO;
        JSONObject params = this.params;
        params.put("id", id);
        params.put("video_type", videoType);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            info = GSON.fromJson(Aes.decrypt(res.getData()), Cp.class);
        } else {
            LOG.warn("get cp info fail: " + res.getMsg());
        }
        return info;
    }

    /**
     * 获取作者的视频列表
     *
     * @param id        作者 ID
     * @param videoType 视频类型，1-横屏，2-竖屏
     * @param page      页数
     * @param size      页大小
     * @return List 视频对象集合
     */
    public List<Video> cpVideoList(String id, int videoType, int page, int size) {
        List<Video> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_CP_VIDEOS;
        JSONObject params = this.params;
        params.put("id", id);
        params.put("video_type", videoType);
        params.put("page", page);
        params.put("size", size);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Video[] list = GSON.fromJson(Aes.decrypt(res.getData()), Video[].class);
            data = Arrays.asList(list);
        } else {
            LOG.warn("get cp video list fail: " + res.getMsg());
        }
        return data;
    }
}
