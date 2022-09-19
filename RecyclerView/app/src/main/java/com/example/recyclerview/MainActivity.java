package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recView = findViewById(R.id.RecView);
        recView.setLayoutManager(new LinearLayoutManager(this));


        arrContacts.add(new ContactModel(R.drawable.one, "XYZ", "32234862"));
        arrContacts.add(new ContactModel(R.drawable.two, "FGD", "565534862"));
        arrContacts.add(new ContactModel(R.drawable.three, "TGZ", "322454862"));
        arrContacts.add(new ContactModel(R.drawable.four, "RGZ", "945634862"));
        arrContacts.add(new ContactModel(R.drawable.five, "DDZ", "322IO862"));
        arrContacts.add(new ContactModel(R.drawable.six, "RYQ", "765234862"));
        arrContacts.add(new ContactModel(R.drawable.seven, "ABCZ", "40000762"));
        arrContacts.add(new ContactModel(R.drawable.two, "FGD", "565534862"));
        arrContacts.add(new ContactModel(R.drawable.three, "TGZ", "322454862"));
        arrContacts.add(new ContactModel(R.drawable.four, "RGZ", "945634862"));
        arrContacts.add(new ContactModel(R.drawable.five, "DDZ", "322IO862"));
        arrContacts.add(new ContactModel(R.drawable.six, "RYQ", "765234862"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
        recView.setAdapter(adapter);
    }
}