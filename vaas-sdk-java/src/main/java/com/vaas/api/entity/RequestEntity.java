package com.vaas.api.entity;

public class RequestEntity {

    private String access_key;
    private String params;
    private long timestamp;
    private String sign;

    public RequestEntity(String access_key, String params, long timestamp, String sign) {
        this.access_key = access_key;
        this.params = params;
        this.timestamp = timestamp;
        this.sign = sign;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getAccess_key() {
        return access_key;
    }

    public String getParams() {
        return params;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
