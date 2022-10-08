package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.show_toast);



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast ts = new Toast(getApplicationContext());
                View view=  getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup)findViewById(R.id.cus_toast));
                ts.setView(view);
                TextView txt = view.findViewById(R.id.txt1);
                txt.setText("A Custom Toast");
                ts.setDuration(Toast.LENGTH_LONG);
                ts.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
                ts.show();
            }
        });
    }
}