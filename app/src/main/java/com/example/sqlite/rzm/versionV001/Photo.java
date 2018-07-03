package com.example.sqlite.rzm.versionV001;

import com.example.sqlite.rzm.db.annotion.DbTable;

@DbTable("tb_photo")
public class Photo {
    public String path;
    public String time;
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
