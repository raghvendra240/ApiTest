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

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    List<Article>articles;
    Context context;

    public MyAdapter(List<Article> articles, Context context) {
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

        String imagrUrl=articles.get(position).getUrlToImage();
        Glide.with(context)
                .load(imagrUrl)
                .into(holder.image);

        holder.title.setText(articles.get(position).getTitle());

        holder.author.setText(articles.get(position).getAuthor());
       //holder.description.setText(articles.get(position).getDescription());


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
