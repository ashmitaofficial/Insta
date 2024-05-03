package com.example.insta_recyclerview.dao;

import com.example.insta_recyclerview.model.Followers_post_model;
import com.example.insta_recyclerview.model.Post_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api_Interface {

    @GET("posts")
    Call<List<Post_model>> getPost();
    @GET("followers/{id}")
    Call<List<Followers_post_model>> getFollowers(@Path("id")int id);
}
