package ylyun.api.entity;

import java.io.Serializable;

public class Play implements Serializable {
    private String name;
    private String uri;
    private long size;
    private String code;
    private String watermark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    @Override
    public String toString() {
        return "Play{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", watermark='" + watermark + '\'' +
                '}';
    }
}