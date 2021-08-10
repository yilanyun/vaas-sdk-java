package com.vaas.api.entity;

import java.io.Serializable;

public class Video implements Serializable {

    private String video_id;
    private String title;
    private String cover;
    private String category;
    private String tags;
    private int duration;
    private String h5_url;
    private String pc_url;
    private String share_url;
    private Author author;
    private String publish_time;
    private int video_w;
    private int video_h;
    private int file_size;
    private int play_num;
    private int like_num;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getH5_url() {
        return h5_url;
    }

    public void setH5_url(String h5_url) {
        this.h5_url = h5_url;
    }

    public String getPc_url() {
        return pc_url;
    }

    public void setPc_url(String pc_url) {
        this.pc_url = pc_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public int getVideo_w() {
        return video_w;
    }

    public void setVideo_w(int video_w) {
        this.video_w = video_w;
    }

    public int getVideo_h() {
        return video_h;
    }

    public void setVideo_h(int video_h) {
        this.video_h = video_h;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public int getPlay_num() {
        return play_num;
    }

    public void setPlay_num(int play_num) {
        this.play_num = play_num;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String toString() {
        return "{" +
                "video_id='" + video_id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", category='" + category + '\'' +
                ", tags='" + tags + '\'' +
                ", duration=" + duration +
                ", h5_url='" + h5_url + '\'' +
                ", pc_url='" + pc_url + '\'' +
                ", share_url='" + share_url + '\'' +
                ", author=" + author.toString() +
                ", publish_time='" + publish_time + '\'' +
                ", video_w=" + video_w +
                ", video_h=" + video_h +
                ", file_size=" + file_size +
                ", play_num=" + play_num +
                ", like_num=" + like_num +
                '}';
    }
}
