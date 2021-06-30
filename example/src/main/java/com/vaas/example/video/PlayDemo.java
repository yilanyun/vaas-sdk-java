package com.vaas.example.video;

import com.vaas.api.entity.CommonParams;
import com.vaas.api.entity.Play;
import com.vaas.api.VaaSClient;
import com.vaas.api.VideoService;

import java.util.List;

public class PlayDemo {

    public static void main(String[] args) {
        CommonParams comm = new CommonParams();
        comm.setUdid("df757f33b10f142596106bb451fa2187");
        comm.setPlatform(5);
        comm.setPkg_name("tv.yilan.qianpai.app");
        VaaSClient client = new VaaSClient(comm);
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        VideoService vs = client.video();
        List<Play> data = vs.play("JMewZ4zoXO5K");
        System.out.println("video play data: ");
        for (Play pl: data) {
            System.out.println(pl.toString());
        }
    }
}
