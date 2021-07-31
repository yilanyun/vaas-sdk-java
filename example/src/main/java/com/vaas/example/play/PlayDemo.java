package com.vaas.example.play;

import com.vaas.api.entity.Play;
import com.vaas.api.VaaSClient;

import java.util.List;

public class PlayDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient(5, "tv.yilan.qianpai.app");
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        client.setUdid("df757f33b10f142596106bb451fa2187");
        List<Play> data = client.video().play("JMewZ4zoXO5K");
        System.out.println("video play data: ");
        for (Play pl: data) {
            System.out.println(pl.toString());
        }
    }
}
