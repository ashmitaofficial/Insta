package com.example.insta_recyclerview.model;

import android.widget.Button;

public class Followers_post_model {
    private String user_img;
    private String user_name;
    private String full_name;
    private boolean bluetick;


    public Followers_post_model(String user_img, String user_name, String full_name, boolean bluetick) {
        this.user_img = user_img;
        this.user_name = user_name;
        this.full_name = full_name;
        this.bluetick = bluetick;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean getBluetick() {
        return bluetick;
    }

    public void setBluetick(boolean bluetick) {
        this.bluetick = bluetick;
    }
}
