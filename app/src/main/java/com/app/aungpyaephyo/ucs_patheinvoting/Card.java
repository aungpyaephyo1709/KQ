package com.app.aungpyaephyo.ucs_patheinvoting;

public class Card {
    private String name;
    private String rno;
    private int thumbnail;

    public Card(String name, String rno, int thumbnail) {
        this.name = name;
        this.rno = rno;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
