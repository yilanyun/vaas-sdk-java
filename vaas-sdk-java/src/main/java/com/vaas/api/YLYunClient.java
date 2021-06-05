package ylyun.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ylyun.common.ClientConfig;
import ylyun.common.utils.GenerateSign;
import ylyun.api.*;

/**
 * 客户端入口
 */
public class YLYunClient {
	
	private String accessKey;
	private String accessToken;
	private String platform;
	private Map<String, String> commParams = new HashMap<String, String>();
	private static final String[] mustKeys = {"udid","model","ver","ip"};

	public YLYunClient(Map<String, String> comm) {
	    this.accessKey = ClientConfig.ACCESS_KEY;
	    this.accessToken = ClientConfig.ACCESS_TOKEN;
	    this.platform = ClientConfig.PLATFORM;
	    checkMustParams(comm);
	    this.commParams.put("access_key", this.accessKey);
	    this.commParams.put("platform", this.platform);
	    this.commParams.put("format", ClientConfig.FORMAT);
	    this.commParams.put("timestamp", "" + System.currentTimeMillis());
	}
	
	//channel service 
	public ChannelService channel() {
		return new ChannelService(this);
	}
	
	//recommend service
	public RecommendService recommend() {
		return new RecommendService(this);
	}
	
	//search service
	public SearchService search() {
		return new SearchService(this);
	}
	
	//video service
	public VideoService video() {
		return new VideoService(this);
	}
	
	//Check must param and config
	private void checkMustParams(Map<String, String> comm) {
		if (this.accessKey == "") {
			throw new IllegalArgumentException("access_key is not config");
		}
		if (this.accessToken == "") {
			throw new IllegalArgumentException("access_token is not config");
		}
		if (this.platform == "") {
			throw new IllegalArgumentException("platform is not config");
		}
		for (String key:mustKeys) {
			if (comm.get(key).isEmpty()) {
				throw new IllegalArgumentException("must param:" + key + " is empty");
			}
			this.commParams.put(key, comm.get(key));
		}
	}
	
	public Map<String, String> getCommParams() {
		return this.commParams;
	}
	
	@SuppressWarnings("unused")
	public String getFullUrl(String uri, Map<String, String> data) {
		String host = ClientConfig.HOST_PROD;
		if (ClientConfig.ENV == ClientConfig.ENV_DEV) {
			host = ClientConfig.HOST_DEV;
		}
		String sign = GenerateSign.getSign(data, uri, this.accessToken);
		data.put("sign", sign);
		String params = GenerateSign.httpBuildQuery(data);
		return host + uri + "?" + params ;
	}
}

