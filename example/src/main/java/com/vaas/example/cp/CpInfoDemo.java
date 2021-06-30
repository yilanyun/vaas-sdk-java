package com.vaas.example.cp;

import com.vaas.api.CpService;
import com.vaas.api.entity.CommonParams;
import com.vaas.api.entity.Cp;
import com.vaas.api.VaaSClient;

public class CpInfoDemo {

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
        Cp info = cs.cpInfo("DVjdRzOxny8d", 1);
        System.out.println("cp data: " + info.toString());
    }
}
