 package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preference = getSharedPreferences("login",MODE_PRIVATE);
                boolean check = preference.getBoolean("flag",false);
                Intent next;
                if(check) //for true i.e. (User is logged in)
                {
                    next=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(next);
                }
                else{ //either first time or user logged out
                    next = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(next);
                }
            }
        }  ,4000);
    }
}