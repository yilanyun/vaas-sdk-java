package com.vaas.api.entity;

import java.io.Serializable;

public class Cp implements Serializable {

    private String id;
    private String name;
    private String avatar;
    private int choice;
    private String aword;
    private int videos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getAword() {
        return aword;
    }

    public void setAword(String aword) {
        this.aword = aword;
    }

    public int getVideos() {
        return videos;
    }

    public void setVideos(int videos) {
        this.videos = videos;
    }

    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", choice=" + choice +
                ", aword='" + aword + '\'' +
                ", videos=" + videos +
                '}';
    }
}