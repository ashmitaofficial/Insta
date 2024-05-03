package com.example.insta_recyclerview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insta_recyclerview.view_model.FollowersList_viewmodel;
import com.example.insta_recyclerview.model.Followers_post_model;
import com.example.insta_recyclerview.R;
import com.example.insta_recyclerview.adapters.ProfilePage_Adapter;

import java.util.List;

public class FollowersListActivity extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private FollowersList_viewmodel viewmodel;
    private ImageButton back_btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_followers_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int uid = getIntent().getIntExtra("uid",-1);


        back_btn2=findViewById(R.id.back_btn);
        recyclerView2 = findViewById(R.id.followers_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);

        viewmodel = new ViewModelProvider(this).get(FollowersList_viewmodel.class);
        viewmodel.getData(uid);
        viewmodel.liveData.observe(this, new Observer<List<Followers_post_model>>() {
            @Override
            public void onChanged(List<Followers_post_model> followersPostModels) {
                recyclerView2.setAdapter(new ProfilePage_Adapter(getApplicationContext(), followersPostModels));
                recyclerView2.getAdapter().notifyDataSetChanged();
            }
        });

        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}