package com.example.insta_recyclerview.model;

import com.google.gson.annotations.SerializedName;

public class Post_model {

    @SerializedName("profilepic")
    private String user_pic;
    @SerializedName("username")
    private String user_name;
    @SerializedName("location")
    private String user_location;
    @SerializedName("postpic")
    private String post_pic;
    @SerializedName("like_count")
    private String likes_count;
    @SerializedName("post_desc")
    private String desc;
    @SerializedName("profile")
    private Profile_model user_detail;

    @SerializedName("is_like")
    private boolean islike;

    public Post_model(String user_pic, String user_name, String user_location, String post_pic, String likes_count, String desc,Profile_model user_detail,boolean isLike) {
        this.user_pic = user_pic;
        this.user_name = user_name;
        this.user_location = user_location;
        this.post_pic = post_pic;
        this.likes_count = likes_count;
        this.desc = desc;
        this.user_detail=user_detail;
        this.islike = isLike;
    }

    //getter

    public boolean isIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_location() {
        return user_location;
    }

    public String getPost_pic() {
        return post_pic;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public String getDesc() {
        return desc;
    }

    public Profile_model getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(Profile_model user_detail) {
        this.user_detail = user_detail;
    }
    //Setter

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public void setPost_pic(String post_pic) {
        this.post_pic = post_pic;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}