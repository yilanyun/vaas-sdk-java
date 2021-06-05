package ylyun.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import ylyun.api.entity.MediaList;
import ylyun.api.entity.MediaInfo;
import ylyun.common.connection.ApacheHttpClient;

/**
 * 视频推荐服务
 */
public class RecommendService {
	
	private static Map<String, String> servUri = new HashMap<String, String>();
	private YLYunClient client;
	private Map<String, String> comm = new HashMap<String, String>();
	private static Logger LOG = LoggerFactory.getLogger(ChannelService.class);
	private static Gson GSON = new Gson();
	
	public RecommendService(YLYunClient client) {
		servUri.put("feed", "/video/feed");
		servUri.put("ugc_feed", "/video/ugcfeed");
		this.client = client;
		this.comm = this.client.getCommParams();
	}
	
	/**
	 * 视频推荐
	 * @param loadType 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道
	 * @param channelId 频道ID
	 * @param uid 用户唯一标识
	 * @return List
	 */
	public List<MediaInfo> recommendFeed(int loadType, int channelId, long uid) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("load_type", loadType + "");
		params.put("channel_id", channelId + "");
		params.put("uid", uid + "");
		String servUrl = this.client.getFullUrl(servUri.get("feed"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("get recommend feed fail");
		}
		return data;
	}
	
	
	/**
	 * 视频推荐
	 * @param loadType 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道
	 * @param channelId 频道ID
	 * @return List
	 */
	public List<MediaInfo> recommendFeed(int loadType, int channelId) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("load_type", loadType + "");
		params.put("channel_id", channelId + "");
		String servUrl = this.client.getFullUrl(servUri.get("feed"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("get recommend feed fail");
		}
		return data;
	}
	
	/**
	 * 小视频推荐列表
	 * @param loadType 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道
	 * @param uid 用户唯一标识
	 * @return List
	 */
	public List<MediaInfo> recommendUgcFeed(int loadType, long uid) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("load_type", loadType + "");
		params.put("uid", uid + "");
		String servUrl = this.client.getFullUrl(servUri.get("ugc_feed"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("get recommend ugc feed fail");
		}
		return data;
	}
	
	/**
	 * 小视频推荐列表
	 * @param loadType 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道
	 * @return List
	 */
	public List<MediaInfo> recommendUgcFeed(int loadType) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("load_type", loadType + "");
		String servUrl = this.client.getFullUrl(servUri.get("ugc_feed"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("get recommend ugc feed fail");
		}
		return data;
	}
}