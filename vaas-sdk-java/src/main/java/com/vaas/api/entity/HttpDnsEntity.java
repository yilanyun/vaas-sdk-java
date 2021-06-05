package ylyun.api.entity;

import java.util.List;

public class HttpDnsEntity extends BaseEntity {
    private String host;
    private List<String> ips;
    private int ttl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "HttpDnsEntity{" +
                "host='" + host + '\'' +
                ", ips=" + ips +
                ", ttl=" + ttl +
                '}';
    }
}
