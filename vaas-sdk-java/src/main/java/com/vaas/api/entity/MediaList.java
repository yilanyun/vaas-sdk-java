package ylyun.api.entity;

import java.util.List;

public class MediaList extends BaseEntity {
    private List<MediaInfo> data;

    public List<MediaInfo> getData() {
        return data;
    }

    public void setData(List<MediaInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MediaList{" +
                "data=" + data +
                '}';
    }
}
