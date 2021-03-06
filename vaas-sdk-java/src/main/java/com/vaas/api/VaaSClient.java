package com.vaas.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vaas.api.entity.ReportParams;
import com.vaas.common.utils.ConfigMap;

/**
 * 客户端入口
 */
public class VaaSClient {

    private JSONObject commParams = new JSONObject();

    public VaaSClient() {
        this.commParams.put("pkg_name", ConfigMap.getValue("PKG_NAME"));
        this.commParams.put("platform", Integer.valueOf(ConfigMap.getValue("PLATFORM")));
    }

    public VaaSClient(ReportParams p) {
        this.commParams = (JSONObject) JSON.toJSON(p);
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

    public ReportService report() {
        this.commParams.put("access_key", ConfigMap.getValue("ACCESS_KEY"));
        return new ReportService(this.commParams);
    }

    public void setPackageName(String pkg_name) {
        this.commParams.put("pkg_name", pkg_name);
    }

    public void setPlatform(int platform) {
        this.commParams.put("platform", platform);
    }

    public void setUdid(String udid) {
        this.commParams.put("udid", udid);
    }

    public void setAccessKey(String accessKey) {
        ConfigMap.setValue("ACCESS_KEY", accessKey);
    }

    public void setAccessToken(String accessToken) {
        ConfigMap.setValue("ACCESS_TOKEN", accessToken);
    }

    public void setVideoHost(String host) {
        ConfigMap.setValue("HOST_VIDEO", host);
    }

    public void setPlayHost(String host) {
        ConfigMap.setValue("HOST_PLAY", host);
    }

    public void setDataHost(String host) {
        ConfigMap.setValue("HOST_DATA", host);
    }
}
