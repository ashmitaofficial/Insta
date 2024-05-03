package com.example.insta_recyclerview.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insta_recyclerview.dao.MyBroadcastReceiver;
import com.example.insta_recyclerview.view_model.HomeViewModel;
import com.example.insta_recyclerview.model.Post_model;
import com.example.insta_recyclerview.R;
import com.example.insta_recyclerview.adapters.HomePage_Adapter;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MyBroadcastReceiver receiver;
    private HomeViewModel viewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        receiver = new MyBroadcastReceiver();
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        intent.setAction("com.abc");
        intent.putExtra("name", "Loading....");
        sendBroadcast(intent);

        // RecyclerView initialization.....
        recyclerView = findViewById(R.id.my_recycler_view);
        progressBar = findViewById(R.id.progress_bar);

        //  setting which type of layout.....
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //jab tak data ni milega tab tak jo wait h usme progress bar ghumega....
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

        //link view model to activity
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getData(this);
        viewModel.liveData.observe(this, new Observer<List<Post_model>>() {
            @Override
            public void onChanged(List<Post_model> postModels) {
                //setting recycler view items in adapter
                recyclerView.setAdapter(new HomePage_Adapter(postModels, getApplicationContext()));
                //refresh recycler view
                recyclerView.getAdapter().notifyDataSetChanged();

                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        });


    }


}
