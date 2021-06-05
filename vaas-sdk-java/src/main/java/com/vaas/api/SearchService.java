package ylyun.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;

import ylyun.api.entity.MediaInfo;
import ylyun.api.entity.MediaList;
import ylyun.common.connection.ApacheHttpClient;

/**
 * 视频频道服务
 */
public class SearchService {
	
	private static Map<String, String> servUri = new HashMap<String, String>();
	private YLYunClient client;
	private Map<String, String> comm = new HashMap<String, String>();
	private static Logger LOG = LoggerFactory.getLogger(ChannelService.class);
	private static Gson GSON = new Gson();
	
	public SearchService(YLYunClient client) {
		servUri.put("search", "/video/search");
		this.client = client;
		this.comm = this.client.getCommParams();
	}
	
	/**
	 * 搜索视频
	 */
	public List<MediaInfo> searchVideo(String keyword) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("key", keyword);
		String servUrl = this.client.getFullUrl(servUri.get("search"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("call search service fail");
		}
		return data;
	}
}
