package com.example.insta_recyclerview.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insta_recyclerview.activity.ProfileActivity;
import com.example.insta_recyclerview.model.Post_model;
import com.example.insta_recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomePage_Adapter extends RecyclerView.Adapter<HomePage_Adapter.MyViewHolder> {

    private List<Post_model> myList;
    private Context context;

    public HomePage_Adapter(List<Post_model> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_recyclerview_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userName.setText(myList.get(position).getUser_name());
        holder.user_location.setText(myList.get(position).getUser_location());
        holder.desc_txt.setText(myList.get(position).getDesc());
        holder.likes_txt.setText(myList.get(position).getLikes_count() + " likes");
        Picasso.get().load(myList.get(position).getPost_pic()).placeholder(R.drawable.errorpic).into(holder.post);
        Picasso.get().load(myList.get(position).getUser_pic()).placeholder(R.drawable.avator).into(holder.userImg);

        if (myList.get(position).isIslike()) {
            holder.likeBtn.setImageResource(R.drawable.liked_btn);
        } else {
            holder.likeBtn.setImageResource(R.drawable.like);
        }

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myList.get(position).isIslike()) {
                    myList.get(position).setIslike(false);
                } else {
                    myList.get(position).setIslike(true);
                }
                //refresh whole recycler view
//                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });

        holder.userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("profile", myList.get(position).getUser_detail());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImg, post;
        private TextView userName, user_location, desc_txt, likes_txt;
        private ImageButton comment_btn, likeBtn, share_btn, bookmark;


        //reference Item elements==link
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userImg = itemView.findViewById(R.id.userImg);
            post = itemView.findViewById(R.id.post);
            userName = itemView.findViewById(R.id.userName);
            user_location = itemView.findViewById(R.id.user_location);
            desc_txt = itemView.findViewById(R.id.desc_txt);
            likes_txt = itemView.findViewById(R.id.likes_txt);
            comment_btn = itemView.findViewById(R.id.comment_btn);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            share_btn = itemView.findViewById(R.id.share_btn);
            bookmark = itemView.findViewById(R.id.bookmark);

        }
    }
}
