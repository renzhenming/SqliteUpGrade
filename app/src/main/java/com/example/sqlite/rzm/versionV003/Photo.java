package com.example.sqlite.rzm.versionV003;

import com.example.sqlite.rzm.db.annotion.DbTable;

@DbTable("tb_photo")
public class Photo {
    public String path;
    public String time;
    public String sendTime;
    public String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
