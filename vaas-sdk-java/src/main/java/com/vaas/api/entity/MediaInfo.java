package ylyun.api.entity;

import java.io.Serializable;
import java.util.UUID;

public class MediaInfo implements Serializable {
    private String log_id;
    private String video_id;
    private String title;
    private String tags;
    private int is_choice;
    private String h5_url;
    private String image;
    private long duration;
    private Provider provider;
    private String publish_date;
    private int video_w;
    private int video_h;
    private int play_num;
    private int like_num;
    private long create_time;
    private long update_time;
    private String referpage;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getIs_choice() {
        return is_choice;
    }

    public void setIs_choice(int is_choice) {
        this.is_choice = is_choice;
    }

    public String getH5_url() {
        return h5_url;
    }

    public void setH5_url(String h5_url) {
        this.h5_url = h5_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
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

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getReferpage() {
        return referpage;
    }

    public void setReferpage(String referpage) {
        this.referpage = referpage;
    }


    @Override
    public String toString() {
        return "MediaInfo{" +
                "log_id='" + log_id + '\'' +
                ", video_id='" + video_id + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", is_choice=" + is_choice +
                ", h5_url='" + h5_url + '\'' +
                ", image='" + image + '\'' +
                ", duration=" + duration +
                ", provider=" + provider +
                ", publish_date='" + publish_date + '\'' +
                ", video_w=" + video_w +
                ", video_h=" + video_h +
                ", play_num=" + play_num +
                ", like_num=" + like_num +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", referpage='" + referpage + '\'' +
                '}';
    }
}
