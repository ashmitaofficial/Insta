package com.example.insta_recyclerview.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.insta_recyclerview.model.Profile_model;
import com.example.insta_recyclerview.R;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    private ImageView userpic;
    private TextView username_act2;
    private TextView user_profession;
    private TextView followers_count;
    private TextView following_count;
    private ImageButton back_btn;
    private Button followers_Btn;
    private Button following_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //get from intent
        Profile_model profileModel = (Profile_model) getIntent().getSerializableExtra("profile");

        userpic = findViewById(R.id.userpic);
        username_act2 = findViewById(R.id.username_act2);
        user_profession = findViewById(R.id.user_profession);
        followers_count = findViewById(R.id.followers_count);
        following_count = findViewById(R.id.following_count);
        back_btn=findViewById(R.id.back_btn);
        followers_Btn=findViewById(R.id.followers_Btn);
        following_btn=findViewById(R.id.following_btn);

//    ----------------------------------------------------------------------------------------------

        user_profession.setText(profileModel.getProfession());
        username_act2.setText(profileModel.getUname());
        following_count.setText(profileModel.getFollowing_count() / 1000 + "k");
        followers_count.setText(profileModel.getFollowers_count() / 1000 + "k");
        Picasso.get().load(profileModel.getPic()).into(userpic);


        //back to home page on back button
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // intent on followers button
        followers_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileActivity.this, FollowersListActivity.class);
                intent.putExtra("uid",profileModel.getId());
                startActivity(intent);
            }
        });

        //setting intent on following button
        following_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileActivity.this, FollowersListActivity.class);
                intent.putExtra("uid",profileModel.getId());
                startActivity(intent);

            }
        });






    }
}