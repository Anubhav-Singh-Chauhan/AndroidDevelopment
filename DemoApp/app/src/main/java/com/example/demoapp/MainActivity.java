package com.example.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView address,longitude,latitude;
    Button start,stop,play;
    private  final  static int REQUEST_CODE=100;
    private static int MICROPHONE_PERMISSION = 200;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address=findViewById(R.id.address);
        longitude=findViewById(R.id.longitude);
        latitude=findViewById(R.id.latitude);
        start = findViewById(R.id.startBtn);
        stop = findViewById(R.id.stopBtn);
        play = findViewById(R.id.playBtn);

        if(isMicroPhonePresent())
        {
            getMicPermission();
        }

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address.setText("Getting Location...");
                getLastLocation();

                try{
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mediaRecorder.setOutputFile(getRecordingFilePath());
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mediaRecorder.prepare();
                    mediaRecorder.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"Recording Started",Toast.LENGTH_LONG).show();
            }

        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLastLocation();

                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
                Toast.makeText(MainActivity.this, "Recording Stopped", Toast.LENGTH_SHORT).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(getRecordingFilePath());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getLastLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location !=null){
                                Geocoder geocoder=new Geocoder(MainActivity.this, Locale.getDefault());
                                List<Address> addresses= null;
                                try {
                                    addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                                    latitude.setText("Lagitude: " +addresses.get(0).getLatitude());
                                    longitude.setText("Longitude: "+addresses.get(0).getLongitude());
                                    address.setText("Address: "+addresses.get(0).getAddressLine(0));

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });


        }else
        {

            askPermission();

        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode==REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }
            else {
                Toast.makeText(this, "Required Permission", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private boolean isMicroPhonePresent()
    {
        if(this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)){
            return true;
        }
        else{
            return false;
        }
    }
    private void getMicPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.RECORD_AUDIO},MICROPHONE_PERMISSION);
        }
    }

    private String getRecordingFilePath(){
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory, "Recordings DemoApp" + ".mp3");
        return file.getPath();
    }
}