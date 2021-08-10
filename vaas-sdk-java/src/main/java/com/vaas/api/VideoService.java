package com.vaas.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.vaas.api.entity.*;
import com.vaas.common.connection.OkHttpClient;
import com.vaas.common.utils.Aes;
import com.vaas.common.utils.ConfigMap;
import com.vaas.common.utils.GenerateSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 视频媒资服务
 */
public class VideoService {

    private final JSONObject params;
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static final Gson GSON = new Gson();
    private static final String SERV_VIDEO_DETAILS = "/video/getvideos";
    private static final String SERV_PLAY = "/vaas/video/play";

    public VideoService(JSONObject params) {
        this.params = params;
    }

    /**
     * 批量获取视频详情
     *
     * @param videoIds  视频ID串，多个用英文逗号隔开
     * @param videoType 视频类型，1-横屏，2-竖屏
     * @return List 视频对象集合
     */
    public List<Video> details(String videoIds, int videoType) {
        List<Video> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_VIDEO_DETAILS;
        JSONObject params = this.params;
        params.put("ids", videoIds);
        params.put("video_type", videoType);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Video[] list = GSON.fromJson(Aes.decrypt(res.getData()), Video[].class);
            data = Arrays.asList(list);
        } else {
            LOG.warn("get video detail fail: " + res.getMsg());
        }
        return data;
    }

    /**
     * 获取视频播放信息
     *
     * @param videoId 视频 ID
     * @return List 播放信息对象集合
     */
    public List<Play> play(String videoId) {
        List<Play> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST_PLAY") + SERV_PLAY;
        JSONObject params = this.params;
        params.put("id", videoId);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Play[] list = GSON.fromJson(Aes.decrypt(res.getData()), Play[].class);
            data = Arrays.asList(list);
        } else {
            LOG.warn("get video play fail: " + res.getMsg());
        }
        return data;
    }
}
