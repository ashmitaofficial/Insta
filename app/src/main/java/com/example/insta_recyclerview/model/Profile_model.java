package com.example.insta_recyclerview.model;

import java.io.Serializable;

public class Profile_model implements Serializable {
  private   int id;
  private String pic;

  private String uname;

  private String profession;

  private int followers_count;

  private int following_count;

    public Profile_model(int id, String pic, String professtion,String uname, int followers_count, int following_count) {
        this.id = id;
        this.pic = pic;
        this.profession = professtion;
        this.followers_count = followers_count;
        this.following_count = following_count;
        this.uname=uname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(int following_count) {
        this.following_count = following_count;
    }
}
