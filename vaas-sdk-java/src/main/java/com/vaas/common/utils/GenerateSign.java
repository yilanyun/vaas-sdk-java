package ylyun.common.utils;

import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

public class GenerateSign {

	public static String getSign(Map<String, String> data, String path, String accessToken) {

		TreeSet<String> sortSet = new TreeSet<>();
	    sortSet.addAll(data.keySet());
	    StringBuilder builder = new StringBuilder(path);
	    if (sortSet != null) {
	        for (String key : sortSet) {
	            builder.append(key + data.get(key));
	        }
	    }
	    String sign = "";
	    try {
	        sign = sdkDecode(accessToken + data.get("timestamp"), builder.toString().trim());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return sign;
	}

	public static String sdkDecode(String secret,String data) throws Exception {
	    try {
	        SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HMACSHA256");
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(secretKey);
	        byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
	        BASE64Encoder encoder = new BASE64Encoder();
	        String encodedString = encoder.encode(bytes);
	        return encodedString.trim();
	    } catch (Exception e) {
	        throw new Exception("sdkDecode fail", e);
	    }
	}
	
	public static String httpBuildQuery(Map<String, String> map) {
		 String str = "";  
		 //遍历数组形成akey=avalue&bkey=bvalue&ckey=cvalue形式的的字符串  
		 for (Map.Entry<String, String> entry : map.entrySet()) { 
			 str += entry.getKey() + "=" + entry.getValue() + "&";
		 }
		 str = str.substring(0, str.length()-1);  
		 str = URLEncoder.encode(str);  
		 str = str.replace("%3D", "=").replace("%26", "&");  
		 return str;  
	}
}
