package com.vaas.example.video;

import java.util.List;

import com.vaas.api.entity.CommonParams;
import com.vaas.api.entity.Video;
import com.vaas.api.VaaSClient;
import com.vaas.api.VideoService;

public class DetailsDemo {

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
        List<Video> data = vs.details("JMewZ4zoXO5K,njz3DnwDD45V", 1);
        System.out.println("video details: ");
        for (Video v: data) {
            System.out.println(v.toString());
        }
    }
}
