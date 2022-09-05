package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nxt;
        nxt = findViewById(R.id.btnNext);
        Intent iNext;
        iNext = new Intent(MainActivity.this,SecondActivity.class);
        iNext.putExtra("title","Home");
        iNext.putExtra("StudentName","Raman");
        iNext.putExtra("Roll no:",10);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(iNext);
            }
        });

    }
}