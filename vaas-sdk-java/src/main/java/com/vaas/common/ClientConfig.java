package ylyun.common;

public class ClientConfig {

	//以下常量上线前需要修改 请咨询一览接口人索取
    public static final String ACCESS_KEY = "ylx36jukc8oq";
    public static final String ACCESS_TOKEN = "ow5um6c233cax89dyuaqzh3g3l4duxdx";
    public static final String PLATFORM = "bjqm";
    public static final String ENV = "prod"; //环境 dev|prod
	public static final String HOST_PROD = "https://openapiv2.yilan.tv";

    //以下配置不需要修改
    public static final String ENV_PROD = "prod";
    public static final String ENV_DEV = "dev";
    public static final String HOST_DEV = "https://testapi.yilan.tv";
    public static final String FORMAT = "json";
    public static final String USER_AGENT = "YLYun-JAVA-Client";
    public static final int MAX_RETRY_NUM = 2;
    public static final int CONN_TIMEOUT = 5000;
    public static final int REQ_TIMEOUT = 10000;
    public static final int SOCKET_TIMEOUT = 5000;
    public static final int HTTP_SUCC = 200;
}
