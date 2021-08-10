package com.vaas.example.report;

import com.vaas.api.ReportService;
import com.vaas.api.VaaSClient;
import com.vaas.api.entity.ReportParams;

public class FeedbackDemo {

    public static void main(String[] args) {
        ReportParams rp = new ReportParams();
        rp.setUdid("df757f33b10f142596106bb451fa2187");
        rp.setBrand("Xiaomi");
        rp.setImeimd5("d8d07e0c769f2244663a0a1139f3e7e5");
        rp.setNt(5);
        long t = System.currentTimeMillis();
        rp.setSn(t);
        rp.setTelecom(1);
        rp.setVer("v2021060290");
        VaaSClient client = new VaaSClient(rp);
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        ReportService vs = client.report();
        vs.feedbackReport("JMewZ4zoXO5K", "YLyGvkl6QA5K", "like");
    }
}
