package com.vaas.example.cp;

import java.util.List;

import com.vaas.api.entity.Video;
import com.vaas.api.VaaSClient;

public class CpVideoListDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient("df757f33b10f142596106bb451fa2187", 5, "tv.yilan.qianpai.app");
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        List<Video> data = client.cp().cpVideoList("d4jrXOJm0OyG", 1, 1, 10);
        System.out.println("cp video list: ");
        for (Video v: data) {
            System.out.println(v.toString());
        }
    }
}
