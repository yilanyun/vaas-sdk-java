package ylyun.api.entity;

import java.util.List;

public class PlayUrlList extends BaseEntity {
    private List<Play> bitrates;

    public List<Play> getBitrates() {
        return bitrates;
    }

    public void setBitrates(List<Play> bitrates) {
        this.bitrates = bitrates;
    }
}
