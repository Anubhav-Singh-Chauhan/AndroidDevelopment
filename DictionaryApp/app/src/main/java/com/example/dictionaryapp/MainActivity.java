package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button btn;
    TextView txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputText);
        btn = findViewById(R.id.search_btn);
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String data=input.getText().toString();
                txt1.setText("Searched for: " + data);

                    if (!Python.isStarted()) {
                        Python.start(new AndroidPlatform(MainActivity.this));
                        Python py = Python.getInstance();
                        PyObject pyobj = py.getModule("dictApp");
                        PyObject obj = pyobj.callAttr("backEnd", data);
                        txt2.setText(obj.toString());
                    } else {
                        Python py = Python.getInstance();
                        PyObject pyobj = py.getModule("dictApp");
                        PyObject obj = pyobj.callAttr("backEnd", data);
                        String str = obj.toString();
                        txt2.setText("Meaning: " + str);
                    }
//                catch (Exception e){
//                    Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
//                }

            }
        });

    }
}