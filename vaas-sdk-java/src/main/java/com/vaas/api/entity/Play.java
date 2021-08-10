package com.vaas.api.entity;

import java.io.Serializable;

public class Play implements Serializable {

    private String uri;
    private long size;
    private String code;
    private String name;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", uri='" + uri + '\'' +
                '}';
    }
}
