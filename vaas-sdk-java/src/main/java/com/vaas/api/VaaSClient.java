package com.vaas.api;

import com.alibaba.fastjson.JSONObject;
import com.vaas.api.entity.CommonEntity;
import com.vaas.common.utils.ConfigMap;

/**
 * 客户端入口
 */
public class VaaSClient {

    private final JSONObject commParams = new JSONObject();

    public VaaSClient(CommonEntity comm) {
        this.commParams.put("udid", comm.getUdid());
        this.commParams.put("platform", comm.getPlatform());
        this.commParams.put("pkg_name", comm.getPkg_name());
    }

    public ChannelService channel() {
        return new ChannelService(this.commParams);
    }

    public RecommendService recommendService() {
        return new RecommendService(this.commParams);
    }

    public VideoService video() {
        return new VideoService(this.commParams);
    }

    public CpService cp() {
        return new CpService(this.commParams);
    }

    public void setAccessKey(String accessKey) {
        ConfigMap.setValue("ACCESS_KEY", accessKey);
    }

    public void setAccessToken(String accessToken) {
        ConfigMap.setValue("ACCESS_TOKEN", accessToken);
    }
}
