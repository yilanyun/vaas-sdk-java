package ylyun.api.entity;

import java.util.List;

public class ChannelList extends BaseEntity{
    private List<Channel> data;

    public List<Channel> getData() {
        return data;
    }

    public void setData(List<Channel> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "code=" + this.getCode() + " ChannelList{" +
                "data=" + data +
                '}';
    }
}
