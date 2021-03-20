package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApi extends AppCompatActivity {

    String BASE_URL = "https://newsapi.org/v2/";
    String API_KEY = "2d2791a8aab340178f3e254165730c71";
    RecyclerView recyclerView;

    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_api);
        temp=findViewById(R.id.temp);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();



    }

    void getData()
    {

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)                                  //<-- Base URL is loaded
                    .addConverterFactory(GsonConverterFactory.create()) //<-- Uses GSON convertor to convert the JSON to JAVA objects
                    .build();

        ApiInterface endPoint= retrofit.create(ApiInterface.class);

        Call<Headlines> result=endPoint.getHeadlines("us",API_KEY);
        result.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, retrofit2.Response<Headlines> response) {
                Headlines res=response.body();


                recyclerView.setAdapter(new MyAdapter(res.getArticles(),NewsApi.this));



            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}