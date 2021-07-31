package com.vaas.example.cp;

import com.vaas.api.entity.Cp;
import com.vaas.api.VaaSClient;

public class CpInfoDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient(5, "tv.yilan.qianpai.app");
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        client.setUdid("df757f33b10f142596106bb451fa2187");
        Cp info = client.cp().cpInfo("DVjdRzOxny8d", 1);
        System.out.println("cp data: " + info.toString());
    }
}
