package com.vaas.common.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigMap {
    private static final Map<String, String> map = new HashMap<>();

    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            Properties p = new Properties();
            p.load(isr);
            // 获取所有 key
            Enumeration enumeration = p.propertyNames();
            while (enumeration.hasMoreElements()) {
                // 遍历key
                String key = (String) enumeration.nextElement();
                // 根据key取值
                String value = p.getProperty(key);
                // 放入map中
                map.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return map.get(key);
    }

    public static void setValue(String key, String value) {
        map.put(key, value);
    }
}
