package com.nekozouneko.mccl.lib;

public class VerifyData {

    private String name;
    private String key;
    private long timestamp;

    // setter

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    // getter

    public String getName() {
        return this.name;
    }

    public String getKey() {
        return this.key;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

}
