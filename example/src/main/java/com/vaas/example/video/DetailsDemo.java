package com.vaas.example.video;

import java.util.List;

import com.vaas.api.entity.Video;
import com.vaas.api.VaaSClient;

public class DetailsDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient();
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        client.setUdid("df757f33b10f142596106bb451fa2187");
        List<Video> data = client.video().details("JMewZ4zoXO5K,njz3DnwDD45V", 1);
        System.out.println("video details: ");
        for (Video v : data) {
            System.out.println(v.toString());
        }
    }
}
