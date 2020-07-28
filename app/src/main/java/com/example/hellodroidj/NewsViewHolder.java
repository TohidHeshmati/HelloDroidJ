package com.example.hellodroidj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView title;
    public TextView text;
    public TextView time;


    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.newsImage);
        this.title = itemView.findViewById(R.id.newsTitle);
        this.text = itemView.findViewById(R.id.newsText);
        this.time = itemView.findViewById(R.id.newsTime);
    }
}
