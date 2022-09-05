package com.example.intents;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String StudentName = fromAct.getStringExtra("StudentName");
        int RollNo = fromAct.getIntExtra("Roll no:",0);

        TextView txtStuInfo;
        txtStuInfo = findViewById(R.id.txtStuInfo);
        txtStuInfo.setText("Roll no: " + RollNo + ", Name: " + StudentName);
        getSupportActionBar().setTitle(title);

    }
}