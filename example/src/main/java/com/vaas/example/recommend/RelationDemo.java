package com.vaas.example.recommend;

import java.util.List;

import com.vaas.api.entity.CommonParams;
import com.vaas.api.entity.Video;
import com.vaas.api.RecommendService;
import com.vaas.api.VaaSClient;

public class RelationDemo {

    public static void main(String[] args) {
        CommonParams comm = new CommonParams();
        comm.setUdid("df757f33b10f142596106bb451fa2187");
        comm.setPlatform(5);
        comm.setPkg_name("vaas-demo");
        VaaSClient client = new VaaSClient(comm);
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        RecommendService rs = client.recommendService();
        List<Video> data = rs.relation("JMewZ4zoXO5K", 8);
        System.out.println("video relation list: ");
        for (Video v: data) {
            System.out.println(v.toString());
        }
    }
}
