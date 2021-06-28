package com.vaas.api;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.vaas.api.entity.ResponseEntity;
import com.vaas.common.connection.OkHttpClient;
import com.vaas.common.utils.ConfigMap;
import com.vaas.common.utils.GenerateSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据上报服务
 */
public class ReportService {

    private final JSONObject params;
    private static final Logger LOG = LoggerFactory.getLogger(ReportService.class);
    private static final Gson GSON = new Gson();
    private static final String AK = ConfigMap.getValue("ACCESS_KEY");
    private static final String HOST = ConfigMap.getValue("HOST_DATA");
    private static final String SERV_DATA = "/log?ts=%s&access_key=%s&udid=%s&m=%s";

    public ReportService(JSONObject params) {
        this.params = params;
    }

    /**
     * 视频曝光上报
     *
     * @param videoId   视频ID
     * @param logId     推荐接口中返回的logId
     * @param referpage 展现来源，channel_xxx-feed页(xxx为频道ID)，vplaypage-相关页
     * @param pos       视频在信息流或者相关页出现的位置，从1开始计算
     */
    public void showReport(String videoId, String logId, String referpage, int pos) {
        String ts = Long.toString(System.currentTimeMillis());
        String udid = this.params.getString("udid");
        String sign = GenerateSign.genReportSign(udid, ts);
        String serverUrl = HOST + String.format(SERV_DATA, ts, AK, udid, sign);
        JSONObject body = new JSONObject();
        body.put("videoid", videoId);
        body.put("logid", logId);
        body.put("referpage", referpage);
        body.put("pos", pos);
        this.params.put("event", "videoshow");
        this.params.put("body", body);
        String postData = JSONObject.toJSONString(this.params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.getMsg().equals("success")) {
            System.out.println("video show report success!");
        } else {
            LOG.warn("video show report fail: " + res.getMsg());
        }
    }

    /**
     * 点击播放上报
     *
     * @param videoId   视频ID
     * @param logId     推荐接口中返回的logId
     * @param referpage 展现来源，channel_xxx-feed页(xxx为频道ID)，vplaypage-相关页
     * @param taskId    播放任务唯一标识，可以采用uuid方式生成
     */
    public void playReport(String videoId, String logId, String referpage, String taskId) {
        String ts = Long.toString(System.currentTimeMillis());
        String udid = this.params.getString("udid");
        String sign = GenerateSign.genReportSign(udid, ts);
        String serverUrl = HOST + String.format(SERV_DATA, ts, AK, udid, sign);
        JSONObject body = new JSONObject();
        body.put("videoid", videoId);
        body.put("logid", logId);
        body.put("referpage", referpage);
        body.put("taskid", taskId);
        this.params.put("event", "videoplay");
        this.params.put("body", body);
        String postData = JSONObject.toJSONString(this.params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.getMsg().equals("success")) {
            System.out.println("video play report success!");
        } else {
            LOG.warn("video play report fail: " + res.getMsg());
        }
    }

    /**
     * 播放时长上报
     *
     * @param videoId 视频ID
     * @param taskId  播放任务唯一标识，可以采用uuid方式生成
     * @param bt      播放开始时间点，单位：秒
     * @param et      播放结束时间点，单位：秒
     * @param rt      上报原因 0-正常结束 1-提前停止播放
     */
    public void playTmReport(String videoId, String taskId, int bt, int et, int rt) {
        String ts = Long.toString(System.currentTimeMillis());
        String udid = this.params.getString("udid");
        String sign = GenerateSign.genReportSign(udid, ts);
        String serverUrl = HOST + String.format(SERV_DATA, ts, AK, udid, sign);
        JSONObject body = new JSONObject();
        body.put("videoid", videoId);
        body.put("taskid", taskId);
        body.put("bt", bt);
        body.put("et", et);
        body.put("rt", rt);
        this.params.put("event", "videoplaytm");
        this.params.put("body", body);
        String postData = JSONObject.toJSONString(this.params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.getMsg().equals("success")) {
            System.out.println("video play time report success!");
        } else {
            LOG.warn("video play time report fail: " + res.getMsg());
        }
    }

    /**
     * 视频反馈上报
     *
     * @param videoId 视频ID
     * @param cpId    作者ID
     * @param action  反馈动作：like喜欢，dislike取消喜欢，follow关注
     */
    public void feedbackReport(String videoId, String cpId, String action) {
        String ts = Long.toString(System.currentTimeMillis());
        String udid = this.params.getString("udid");
        String sign = GenerateSign.genReportSign(udid, ts);
        String serverUrl = HOST + String.format(SERV_DATA, ts, AK, udid, sign);
        JSONObject body = new JSONObject();
        body.put("videoid", videoId);
        body.put("cpid", cpId);
        body.put("action", action);
        this.params.put("event", "videofeedback");
        this.params.put("body", body);
        String postData = JSONObject.toJSONString(this.params);
        String ret = OkHttpClient.httpPost(serverUrl, postData);
        ResponseEntity res = GSON.fromJson(ret, ResponseEntity.class);
        if (res.getMsg().equals("success")) {
            System.out.println("video feedback report success!");
        } else {
            LOG.warn("video feedback report fail: " + res.getMsg());
        }
    }
}
