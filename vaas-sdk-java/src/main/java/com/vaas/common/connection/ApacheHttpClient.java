package ylyun.common.connection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

public class ApacheHttpClient {

    private final static String USER_AGENT = "Mozilla/5.0";
    private static int SC_OK = 200; 
    private static int CONN_TIMEOUT = 5000;
    private static int REQ_TIMEOUT = 5000;
    private static int SOCKET_TIMEOUT = 5000;
    private static Logger LOG = LoggerFactory.getLogger(ApacheHttpClient.class);
    
    /**
     * 发送GET请求
     * @param url 路径
     * @return String
     */
    public static String httpGet(String url) {
        //get请求返回结果
        //JSONObject jsonResult = null;
        String strResult = "";
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            //发送get请求
            HttpGet httpGet = new HttpGet(url);
            //超时设置
            RequestConfig requestConfig = RequestConfig.custom()
            		.setConnectTimeout(CONN_TIMEOUT)
                    .setConnectionRequestTimeout(REQ_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();
            httpGet.setConfig(requestConfig);
            //添加请求头
            httpGet.addHeader("User-Agent", USER_AGENT);
            httpGet.addHeader("Content-Type", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == SC_OK) {
                //读取服务器返回过来的json字符串数据
                strResult = EntityUtils.toString(response.getEntity());
                //把json字符串转换成json对象
                //jsonResult = JSONObject.fromObject(strResult);
            } else {
            	url = URLDecoder.decode(url, "UTF-8");
                LOG.error("http get request fail:" + url);
            }
        } catch (IOException e) {
            LOG.error("http get request fail:" + url, e);
        }
        return strResult;
    }

    /**
     * 发送post请求
     * @param url  url地址
     * @param list 参数
     * @return json
     */
    public static String httpPost(String url,  List<NameValuePair> urlParameters ){
    	String strResult = "";
        try {
        	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            //超时设置
            RequestConfig requestConfig = RequestConfig.custom()
            		.setConnectTimeout(CONN_TIMEOUT)
                    .setConnectionRequestTimeout(REQ_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();
            httpPost.setConfig(requestConfig);
        	//增加支持json的http头信息
        	httpPost.setHeader("User-Agent", USER_AGENT);
            httpPost.addHeader("Content-Type", "application/json");
            if (null != urlParameters) {
                //解决中文乱码问题
                //StringEntity entity = new StringEntity(new UrlEncodedFormEntity(urlParameters), "utf-8");
                //entity.setContentEncoding("UTF-8");
                //entity.setContentType("application/json");
                httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
            }
            HttpResponse result = httpClient.execute(httpPost);
            url = URLDecoder.decode(url, "UTF-8");
            //请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == SC_OK) {
                try {
                    //读取服务器返回过来的json字符串数据
                    strResult = EntityUtils.toString(result.getEntity());
                } catch (Exception e) {
                    LOG.error("http post request fail:" + url, e);
                }
            }
        } catch (IOException e) {
            LOG.error("http post request fail:" + url, e);
        }
        return strResult;
    }
}
