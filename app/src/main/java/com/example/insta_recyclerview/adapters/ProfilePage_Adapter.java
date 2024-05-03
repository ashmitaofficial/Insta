package com.example.insta_recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insta_recyclerview.model.Followers_post_model;
import com.example.insta_recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfilePage_Adapter extends RecyclerView.Adapter<ProfilePage_Adapter.MyViewHolder2> {
    private Context context;

    private List<Followers_post_model> mylist;

    public ProfilePage_Adapter(Context context, List<Followers_post_model> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.followers_recyclerview_items, parent, false);
        return new ProfilePage_Adapter.MyViewHolder2(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Picasso.get().load(mylist.get(position).getUser_img()).placeholder(R.drawable.errorpic).into(holder.user_img);
        holder.user_name.setText(mylist.get(position).getUser_name());
        holder.full_name.setText(mylist.get(position).getFull_name());
        if(!mylist.get(position).getBluetick()){
            holder.bluetick.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{

        private ImageView user_img, bluetick;
        private TextView user_name,full_name;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            user_img=itemView.findViewById(R.id.user_img);
            user_name=itemView.findViewById(R.id.user_name);
            full_name=itemView.findViewById(R.id.full_name);
            bluetick=itemView.findViewById(R.id.bluetick);

        }


    }

}
