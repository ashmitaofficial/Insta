package com.example.insta_recyclerview.view_model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.insta_recyclerview.dao.Api_Interface;
import com.example.insta_recyclerview.model.Followers_post_model;
import com.example.insta_recyclerview.dao.RetrofitBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FollowersList_viewmodel extends ViewModel {
    private Retrofit retrofit=null;
    public MutableLiveData<List<Followers_post_model>> liveData=new MutableLiveData<>();
    public void getData(int id) {

        retrofit = RetrofitBuilder.buildObject();

        retrofit.create(Api_Interface.class).getFollowers(id).enqueue(new Callback<List<Followers_post_model>>() {
            @Override
            public void onResponse(Call<List<Followers_post_model>> call, Response<List<Followers_post_model>> response) {
               List<Followers_post_model> list= response.body();
               liveData.postValue(list);

            }

            @Override
            public void onFailure(Call<List<Followers_post_model>> call, Throwable t) {
                Log.e("error",t.getMessage());

            }
        });

    }
}
