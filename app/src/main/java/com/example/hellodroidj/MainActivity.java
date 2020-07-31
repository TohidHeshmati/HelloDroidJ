package com.example.hellodroidj;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecyclerView;

    List<NewsItem> newsItems = Arrays.asList(new NewsItem(1, "title", "subtitle", "text", R.drawable.chill, "description", "time", "publisher"),
            new NewsItem(2, "titlehgjhg", "subtitle", "text", R.drawable.marsian, "description", "time", "publisher"),
            new NewsItem(3, "titlghjgjhe", "subtitle", "text", R.drawable.photo1, "description", "time", "publisher"),
            new NewsItem(4, "tgjhgitle", "subtitle", "text", R.drawable.vintage_cartoon, "description", "time", "publisher"),
            new NewsItem(5, "title", "subtitle", "text", R.drawable.simpson, "description", "time", "publisher"),
            new NewsItem(6, "title", "subtitle", "text", R.drawable.oinocio, "description", "time", "publisher"),
            new NewsItem(7, "title", "subtitle", "text", R.drawable.simpson, "description", "time", "publisher"),
            new NewsItem(8, "title", "subtitle", "text", R.drawable.simpson, "description", "time", "publisher"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = findViewById(R.id.newsRecycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        newsRecyclerView.setLayoutManager(linearLayoutManager);

//        NewsAdapter newsAdapter = new NewsAdapter(newsItems);
        newsRecyclerView.setAdapter(new NewsAdapter(newsItems, new NewsAdapter.OnNewsItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getApplicationContext(), NewsDetailActivity.class);
                //Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.putExtra("imageId", newsItems.get(position).getImageId());
                intent.putExtra("imageDesc", newsItems.get(position).getImageDescription());
                intent.putExtra("title", newsItems.get(position).getTitle());
                intent.putExtra("subTitle", newsItems.get(position).getSubTitle());
                intent.putExtra("time", newsItems.get(position).getTime());
                intent.putExtra("text", newsItems.get(position).getText());
                intent.putExtra("publisher", newsItems.get(position).getPublisher());
            }
        }));
    }

}
