package com.vaas.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import com.vaas.api.entity.RequestEntity;

public class GenerateSign {

    public static String getPostBodyData(JSONObject data) {
        String accessKey = ConfigMap.getValue("ACCESS_KEY");
        String accessToken = ConfigMap.getValue("ACCESS_TOKEN");
        Object obj = JSONObject.toJSON(data);
        String json = obj.toString();
        String enData = Aes.encrypt(json);
        long timestamp = System.currentTimeMillis();
        String sign = "";
        try {
            sign = genSign(accessToken + timestamp, enData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestEntity req = new RequestEntity(accessKey, enData, timestamp, sign);
        return JSONObject.toJSONString(req);
    }

    public static String genSign(String secret, String data) {
        String sign = "";
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HMACSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            sign = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }
}
