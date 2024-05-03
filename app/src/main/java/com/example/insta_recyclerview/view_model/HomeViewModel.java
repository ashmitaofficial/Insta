package com.example.insta_recyclerview.view_model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.insta_recyclerview.R;
import com.example.insta_recyclerview.dao.Api_Interface;
import com.example.insta_recyclerview.model.Post_model;
import com.example.insta_recyclerview.dao.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeViewModel extends ViewModel {

    private Retrofit retrofit=null;
    public MutableLiveData<List<Post_model>> liveData=new MutableLiveData<>();

    public void getData(Context context) {
        //object mil jayega isme
        retrofit = RetrofitBuilder.buildObject();

        // Linking Api by retrofit....
        retrofit.create(Api_Interface.class).getPost().enqueue(new Callback<List<Post_model>>() {
            //when the data is successfully fetched from API....
            @Override
            public void onResponse(Call<List<Post_model>> call, Response<List<Post_model>> response) {
                List<Post_model> listnew = response.body();
                liveData.postValue(listnew);

            }

            //when the data is  not fetched from API....
            @Override
            public void onFailure(Call<List<Post_model>> call, Throwable t) {
                Toast.makeText(context,context.getResources().getString(R.string.api_error),Toast.LENGTH_LONG).show();
            }
        });

    }


}
