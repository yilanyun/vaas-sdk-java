package com.vaas.example.cp;

import java.util.List;

import com.vaas.api.CpService;
import com.vaas.api.entity.CommonParams;
import com.vaas.api.entity.Video;
import com.vaas.api.VaaSClient;

public class CpVideoListDemo {

    public static void main(String[] args) {
        CommonParams comm = new CommonParams();
        comm.setUdid("df757f33b10f142596106bb451fa2187");
        comm.setPlatform(5);
        comm.setPkg_name("tv.yilan.qianpai.app");
        VaaSClient client = new VaaSClient(comm);
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        CpService cs = client.cp();
        List<Video> data = cs.cpVideoList("d4jrXOJm0OyG", 1, 1, 10);
        System.out.println("cp video list: ");
        for (Video v: data) {
            System.out.println(v.toString());
        }
    }
}
