package com.example.apitest;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class MySecondAdapter extends RecyclerView.Adapter<MySecondAdapter.MyViewholder> {

    List<Datum>articles;
    Context context;

    public MySecondAdapter(List<Datum> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedlayout, parent, false);

        MyViewholder vh = new MyViewholder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

       String url=articles.get(position).getAvatar();
        Glide.with(context)
                .load(url)
                .into(holder.image);

        String name=articles.get(position).getFirstName()+" "+articles.get(position).getLastName();


        holder.title.setText(name);
        holder.author.setText(articles.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public class MyViewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView author,title,description;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            author=itemView.findViewById(R.id.author);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
        }
    }
}

