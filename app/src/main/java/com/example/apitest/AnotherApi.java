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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class AnotherApi extends AppCompatActivity {

    TextView text;
    String BASE_URL="https://reqres.in/api/users?page=1";
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_api);

        recyclerView=findViewById(R.id.secondRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final Gson gson = new Gson();
        RequestQueue queue = Volley.newRequestQueue(this);



        StringRequest request = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                SecondApi resultData=gson.fromJson(response,SecondApi.class);
                String t=resultData.getPerPage().toString();
                Toast.makeText(AnotherApi.this, ""+t, Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(new MySecondAdapter(resultData.getData(),AnotherApi.this));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AnotherApi.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


         queue.add(request);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}