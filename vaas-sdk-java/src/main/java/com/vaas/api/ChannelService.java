package com.vaas.api;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.vaas.api.entity.ResponseEntity;
import com.vaas.api.entity.Channel;
import com.vaas.common.connection.OkHttpClient;
import com.vaas.common.utils.Aes;
import com.vaas.common.utils.ConfigMap;
import com.vaas.common.utils.GenerateSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 视频频道服务
 */
public class ChannelService {

    private final JSONObject params;
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static final Gson GSON = new Gson();
    private static final String SERV_CHANNEL = "/video/channels";

    public ChannelService(JSONObject params) {
        this.params = params;
    }

    /**
     * 获取渠道的频道列表
     *
     * @return List 频道对象集合
     */
    public List<Channel> getChannel() {
        List<Channel> data = new ArrayList<>();
        String serverUrl = ConfigMap.getValue("HOST") + SERV_CHANNEL;
        JSONObject params = this.params;
        String postData = GenerateSign.getPostBodyData(params);
        System.out.println(postData);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.isOk() && !res.getData().isEmpty()) {
            Channel[] cl = GSON.fromJson(Aes.decrypt(res.getData()), Channel[].class);
            data = Arrays.asList(cl);
        } else {
            LOG.warn("get channel fail: " + res.getMsg());
        }
        return data;
    }
}
