package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNewsApi,btnsecondApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewsApi=findViewById(R.id.btnNewsApi);
        btnsecondApi=findViewById(R.id.btnSeconApi);

        btnNewsApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,NewsApi.class);
                startActivity(intent);

            }
        });

        btnsecondApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AnotherApi.class);
                startActivity(intent);
            }
        });



    }
}