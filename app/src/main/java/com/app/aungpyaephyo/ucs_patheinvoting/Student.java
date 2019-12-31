package com.app.aungpyaephyo.ucs_patheinvoting;

public class Student {
    String name;
    String section;
    int photo;

    public Student(String name, String section, int photo) {
        this.name = name;
        this.section = section;
        this.photo=photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
