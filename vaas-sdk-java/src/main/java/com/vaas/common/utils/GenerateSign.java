package com.vaas.common.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import com.vaas.api.entity.RequestEntity;

public class GenerateSign {

    private static final String ACCESS_KEY = ConfigMap.getValue("ACCESS_KEY");
    private static final String ACCESS_TOKEN = ConfigMap.getValue("ACCESS_TOKEN");
    private static final String DATA_SIGN_MODEL = "13149876%s%s%s98761314";

    public static String getPostBodyData(JSONObject data) {
        Object obj = JSONObject.toJSON(data);
        String json = obj.toString();
        String enData = Aes.encrypt(json);
        long timestamp = System.currentTimeMillis();
        String sign = "";
        try {
            sign = genSign(ACCESS_TOKEN + timestamp, enData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestEntity req = new RequestEntity(ACCESS_KEY, enData, timestamp, sign);
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

    public static String genReportSign(String udid, String ts) {
        String str = String.format(DATA_SIGN_MODEL, ts, ACCESS_KEY, udid);
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code.insert(0, "0");
        }
        return md5code.toString();
    }
}
