package ylyun.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import ylyun.api.entity.Channel;
import ylyun.api.entity.ChannelList;
import ylyun.common.connection.ApacheHttpClient;

/**
 * 视频频道服务
 */
public class ChannelService {
	
	private static Map<String, String> servUri = new HashMap<String, String>();
	private YLYunClient client;
	private Map<String, String> comm = new HashMap<String, String>();
	private static Logger LOG = LoggerFactory.getLogger(ChannelService.class);
	private static Gson GSON = new Gson();
	
	public ChannelService(YLYunClient client) {
		servUri.put("channel", "/video/getchannel");
		this.client = client;
		this.comm = this.client.getCommParams();
	}
	
	/**
	 * 获取频道
	 */
	public List<Channel> getChannel() {
		List<Channel> data = new ArrayList<Channel>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		String servUrl = this.client.getFullUrl(servUri.get("channel"), params);
		//发送请求
		String ret = ApacheHttpClient.httpGet(servUrl);
		ChannelList list = GSON.fromJson(ret, ChannelList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("get channel fail");
		}
		return data;
	}
}