package com.vaas.example.video;

import java.util.List;

import com.vaas.api.entity.Video;
import com.vaas.api.VaaSClient;

public class FeedDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient();
        client.setUdid("df757f33b10f142596106bb451fa2187");
        List<Video> data = client.recommendService().feed(2, 10169, 0, 6);
        System.out.println("video feed list: ");
        for (Video v : data) {
            System.out.println(v.toString());
        }
    }
}
