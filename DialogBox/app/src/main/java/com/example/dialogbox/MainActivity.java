package com.example.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Single Button Dialog Box

//        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("Sample Dialog Box");
//        alertDialog.setIcon(R.drawable.icon_dialogbox);
//        alertDialog.setMessage("This is an Alert Dialog Box");
//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"Okay!!",new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Perfect!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialog.show();

        //Two Button

//        AlertDialog.Builder delete = new AlertDialog.Builder(MainActivity.this);
//        delete.setTitle("Delete");
//        delete.setIcon(R.drawable.ic_baseline_delete_forever_24);
//        delete.setMessage("Are You Sure, You want to delete?");
//        delete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        delete.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        delete.show();
//
//    }
//
//    //Three Buttons
//
    }

        public void onBackPressed(){

            AlertDialog.Builder exit = new AlertDialog.Builder(MainActivity.this);
            exit.setTitle("Exit");
            exit.setMessage("Do you really want to exit?");
            exit.setIcon(R.drawable.ic_baseline_arrow_back_ios_24);

            exit.setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
                }
            });

            exit.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.super.onBackPressed();
                }
            });

            exit.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                }
            });

            exit.show();
        }
    }