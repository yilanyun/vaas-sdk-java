package com.vaas.example.channel;

import java.util.List;

import com.vaas.api.ChannelService;
import com.vaas.api.entity.Channel;
import com.vaas.api.entity.CommonParams;
import com.vaas.api.VaaSClient;

public class GetChannelDemo {

    public static void main(String[] args) {
        CommonParams comm = new CommonParams();
        comm.setUdid("df757f33b10f142596106bb451fa2187");
        comm.setPlatform(5);
        comm.setPkg_name("tv.yilan.qianpai.app");
        VaaSClient client = new VaaSClient(comm);
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        ChannelService cs = client.channel();
        List<Channel> data = cs.getChannel();
        System.out.println("channel data: ");
        for (Channel ch: data) {
            System.out.println(ch.toString());
        }
    }
}
