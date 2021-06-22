package com.vaas.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.vaas.api.entity.ResponseEntity;
import com.vaas.api.entity.Video;
import com.vaas.common.connection.OkHttpClient;
import com.vaas.common.utils.Aes;
import com.vaas.common.utils.ConfigMap;
import com.vaas.common.utils.GenerateSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 视频推荐服务
 */
public class RecommendService {

    private final JSONObject params;
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static final Gson GSON = new Gson();
    private static final String SERV_FEED = "/video/feed";
    private static final String SERV_RELATION = "/video/relation";

    public RecommendService(JSONObject params) {
        this.params = params;
    }

    /**
     * 视频信息流推荐
     *
     * @param videoType 视频类型，1-横版，2-竖版
     * @param channelId 频道 ID
     * @param loadType  加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道
     * @param size      返回条数（1～8）
     * @return List 视频对象集合
     */
    public List<Video> feed(int videoType, int channelId, int loadType, int size) {
        List<Video> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_FEED;
        JSONObject params = this.params;
        params.put("video_type", videoType);
        params.put("channel_id", channelId);
        params.put("load_type", loadType);
        params.put("size", size);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Video[] list = GSON.fromJson(Aes.decrypt(res.getData()), Video[].class);
            data = Arrays.asList(list);
        } else {
            LOG.warn("get video recommend feed fail: " + res.getMsg());
        }
        return data;
    }

    /**
     * 视频相关推荐
     *
     * @param id   视频 ID
     * @param size 返回条数（1～20）
     * @return List 视频对象集合
     */
    public List<Video> relation(String id, int size) {
        List<Video> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_RELATION;
        JSONObject params = this.params;
        params.put("id", id);
        params.put("size", size);
        String postData = GenerateSign.getPostBodyData(params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Video[] list = GSON.fromJson(Aes.decrypt(res.getData()), Video[].class);
            data = Arrays.asList(list);
        } else {
            LOG.warn("get video recommend relation fail: " + res.getMsg());
        }
        return data;
    }
}
