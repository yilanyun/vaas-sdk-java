package ylyun.api.entity;

import java.io.Serializable;

public class MediaDetail extends BaseEntity implements Serializable {
    private String video_id;
    private String title;
    private String image;
    private String duration;
    private String create_time;
    private Provider provider;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "MediaDetail{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", duration='" + duration + '\'' +
                ", create_time='" + create_time + '\'' +
                ", provider=" + provider +
                '}';
    }
}
