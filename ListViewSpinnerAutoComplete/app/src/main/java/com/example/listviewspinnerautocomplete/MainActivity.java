package com.example.listviewspinnerautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner01;
    AutoCompleteTextView acTxtView;

    ArrayList <String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLanguages = new ArrayList<>();
    int[] arrNo = new int[] {1,2,3,4,5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner01 = findViewById(R.id.spinner1);
        acTxtView = findViewById(R.id.acTxtView);

        arrNames.add("Ram");
        arrNames.add("Ram");
        arrNames.add("Raman");
        arrNames.add("Raman");
        arrNames.add("Jason");
        arrNames.add("Jason");
        arrNames.add("Sam");
        arrNames.add("Sammy");
        arrNames.add("Sammy");
        arrNames.add("John");
        arrNames.add("John");
        arrNames.add("Johnny");
        arrNames.add("Jessie");
        arrNames.add("Jessie");
        arrNames.add("Jack");
        arrNames.add("Jack");

        ArrayAdapter <String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1 );
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(MainActivity.this, "Clicked First Item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //spinner

        arrIds.add("Aadhar Card");
        arrIds.add("Pan Card");
        arrIds.add("ID card");
        arrIds.add("Marksheet");
        arrIds.add("Ration Card");
        arrIds.add("DL Card");

        ArrayAdapter <String> arrayAdapterSpinner = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrIds);
        spinner01.setAdapter(arrayAdapterSpinner);


        //AutoComplete Textview

        arrLanguages.add("English");
        arrLanguages.add("Hindi");
        arrLanguages.add("German");
        arrLanguages.add("Spanish");
        arrLanguages.add("Japanese");
        arrLanguages.add("Urdu");

        ArrayAdapter <String> acAdapater = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrLanguages);
        acTxtView.setAdapter(acAdapater);
        acTxtView.setThreshold(1);


    }
}