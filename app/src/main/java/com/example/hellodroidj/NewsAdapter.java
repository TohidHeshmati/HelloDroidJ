package com.example.hellodroidj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsItem> mainItems;

    public NewsAdapter(List<NewsItem> mainItems) {
        this.mainItems = mainItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsViewHolder viewHolder = (NewsViewHolder) holder;
        NewsItem item = mainItems.get(position);
        viewHolder.imageView.setImageResource(item.getImageId());
        viewHolder.text.setText(item.getText());
        viewHolder.time.setText(item.getTime());
        viewHolder.title.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return mainItems.size();
    }
}
