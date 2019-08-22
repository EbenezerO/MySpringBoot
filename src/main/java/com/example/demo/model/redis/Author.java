package com.example.demo.model.redis;

public class Author {
    private String name;
    private String Intro_l;

    public void setName(String name) {
        this.name = name;
    }

    public void setIntro_l(String intro_l) {
        Intro_l = intro_l;
    }

    public String getName() {
        return name;
    }

    public String getIntro_l() {
        return Intro_l;
    }

    @Override
    public String toString() {
        return getName()+getIntro_l();
    }
}
