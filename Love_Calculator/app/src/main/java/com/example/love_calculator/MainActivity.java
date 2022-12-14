package com.example.love_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView male, female;
    TextView txt;
    String result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn = findViewById(R.id.button);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showResult(v);
           }
       });

    }


    public void showResult(View v)
    {
        male= (EditText) findViewById(R.id.textView4);
        female = (EditText) findViewById(R.id.textView5);
        txt = (TextView) findViewById(R.id.textView3);
        String f=female.getText().toString();
        String m= male.getText().toString();

        String sum = m+f;
        sum=sum.toLowerCase();

        int value=sum.hashCode();
        Random random = new Random(value);
        result = (random.nextInt(100)+1)+" %";
        txt.setText(result);

    }
}