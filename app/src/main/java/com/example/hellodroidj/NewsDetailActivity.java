package com.example.hellodroidj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {
    ImageView newsImage;
    TextView newsTitle;
    TextView newsSubTitle;
    TextView newsImageDescription;
    TextView newsTime;
    TextView newsPublisher;
    TextView newsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //define the View for this activity
        setContentView(R.layout.news_detail_fragment);

        newsImage = findViewById(R.id.newsImage);
        newsTitle = findViewById(R.id.newsTitle);
        newsSubTitle = findViewById(R.id.newsSubtitle);
        newsImageDescription = findViewById(R.id.newsImageDescription);
        newsTime = findViewById(R.id.newsTime);
        newsPublisher = findViewById(R.id.newsPublisher);
        newsText = findViewById(R.id.newsText);

        Intent intent = getIntent();
        if (intent != null) {
            newsImage.setImageResource(intent.getIntExtra("imageId", 0));
            newsTitle.setText(intent.getStringExtra("title"));
            newsImageDescription.setText(intent.getStringExtra("imageDesc"));
            newsSubTitle.setText(intent.getStringExtra("subTitle"));
            newsTime.setText(intent.getStringExtra("time"));
            newsText.setText(intent.getStringExtra("text"));
            newsPublisher.setText(intent.getStringExtra("publisher"));
        }
    }
}