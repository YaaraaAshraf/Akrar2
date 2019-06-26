package com.example.akrar;

public class MyListData {
    String notiname,time;

    public MyListData(String notiname, String time) {
        this.notiname = notiname;
        this.time = time;
    }

    public String getNotiname() {
        return notiname;
    }

    public void setNotiname(String notiname) {
        this.notiname = notiname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
