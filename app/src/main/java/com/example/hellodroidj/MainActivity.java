package com.example.hellodroidj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecyclerView;
    public ProgressDialog progressDialog;

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

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        newsRecyclerView.setLayoutManager(linearLayoutManager);
//
////        NewsAdapter newsAdapter = new NewsAdapter(newsItems);
//        newsRecyclerView.setAdapter(new NewsAdapter(newsItems, new NewsAdapter.OnNewsItemClickListener() {
//            @Override
//            public void onItemClicked(int position) {
//                Intent intent = new Intent(getApplicationContext(), NewsDetailActivity.class);
//                //Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
//                intent.putExtra("imageId", newsItems.get(position).getImageId());
//                intent.putExtra("imageDesc", newsItems.get(position).getImageDescription());
//                intent.putExtra("title", newsItems.get(position).getTitle());
//                intent.putExtra("subTitle", newsItems.get(position).getSubTitle());
//                intent.putExtra("time", newsItems.get(position).getTime());
//                intent.putExtra("text", newsItems.get(position).getText());
//                intent.putExtra("publisher", newsItems.get(position).getPublisher());
//            }
//        }));

        HttpGetRequest httpGetRequest = new HttpGetRequest();
        httpGetRequest.execute("http://www.example.com");
    }

    public String getRequest(String stringUrl) {
        try {
            URL url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.connect();

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String inputLine = "";

            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            reader.close();
            streamReader.close();

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public String postRequest(String stringUrl, String parameters) {
        byte[] postData = parameters.getBytes(Charset.forName("UTF-8"));

        try {
            URL url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);

            //this is needed to set body for output
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(postData.length));
            connection.setUseCaches(false);
            connection.getOutputStream().write(postData);

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String inputLine = "";

            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            reader.close();
            streamReader.close();

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    private class HttpGetRequest extends AsyncTask<String, Integer, String> {
        // 4 state of an async, before, while, after, background

        // on main thread, such as progress bar
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setVolumeControlStream(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            try {
                URL url = new URL(stringUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setReadTimeout(30000);
                connection.setConnectTimeout(30000);
                connection.connect();

                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);

                StringBuilder stringBuilder = new StringBuilder();
                String inputLine = "";

                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }

                reader.close();
                streamReader.close();

                return stringBuilder.toString();

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            }
        }
        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);
            progressDialog.hide();
            Log.e("result", result);
        }
    }
}
